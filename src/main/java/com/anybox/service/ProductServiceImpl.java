package com.anybox.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anybox.dao.PreorderRecordDAO;
import com.anybox.dao.ProductDAO;
import com.anybox.dao.TrayDAO;
import com.anybox.model.PreorderRecord;
import com.anybox.model.Product;
import com.anybox.model.ProductWithDetail;
import com.anybox.model.Tray;
import com.anybox.utils.DateUtils;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired(required = true)
	@Qualifier(value = "productDAO")
	private ProductDAO productDAO;

	@Autowired(required = true)
	@Qualifier(value = "trayDAO")
	private TrayDAO trayDAO;

	@Autowired(required = true)
	@Qualifier(value = "preorderRecordDAO")
	private PreorderRecordDAO preorderRecordDAO;

	@Override
	@Transactional
	public Product add(Product p) {
		return this.productDAO.add(p);
	}

	@Override
	@Transactional
	public Product update(Product p) {
		return this.productDAO.update(p);
	}

	@Override
	@Transactional
	public List<Product> list() {
		return this.productDAO.list();
	}

	@Override
	@Transactional
	public Product getById(int id) {
		return this.productDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		this.productDAO.delete(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.REPEATABLE_READ)
	public List<ProductWithDetail> listWithDetail(int machineId, int userId,
			String date) {

		List<ProductWithDetail> list = new ArrayList<ProductWithDetail>();
		
		// step 1, get Tray list of machineId
		DetachedCriteria dc1 = DetachedCriteria.forClass(Tray.class);
		dc1.add(Restrictions.eq("machine_id", machineId));
		List<Tray> trayList = this.trayDAO.listWithCriteria(dc1);

		// step 2, traverse Tray list to get product map <productId, total
		// capacity>
		Map<Integer, Integer> productMap = new HashMap<Integer, Integer>();
		for (Tray tray : trayList) {
			int productId = tray.getProductId();
			int capacity = tray.getCapacity();

			productMap.put(productId, productMap.containsKey(productId) ? productMap.get(productId) + capacity : capacity);
		}

		// step 3, search PreorderRecord Table with productId in product map, date, machineId
		// if entry exists, calculate free capacity
		// if entry not exists, add entry with total capacity
		Iterator<Entry<Integer, Integer>> iterator = productMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> entry = iterator.next();
			int productId = entry.getKey();
			Date d = DateUtils.stringToDate(date, DateUtils.formatPattern_Short);
			
			DetachedCriteria dc2 = DetachedCriteria.forClass(PreorderRecord.class);
			dc2.add(Restrictions.eq("productId", productId));
			dc2.add(Restrictions.eq("machine_id", machineId));
			dc2.add(Restrictions.eq("date", d));
			
			List<PreorderRecord> recordList = this.preorderRecordDAO.listWithCriteria(dc2);
			
			ProductWithDetail pd = new ProductWithDetail();
			
			pd.setProduct(this.getById(productId));
			
			if(recordList.size() > 0) {
				//calculate free capacity
				pd.setAmount(recordList.get(0).getCapacity() - recordList.get(0).getPreorderCapacity());
			}
			else {
				pd.setAmount(entry.getValue());
				
				//add entry with total capacity
				PreorderRecord record = new PreorderRecord();
				record.setCapacity(entry.getValue());
				record.setDate(d);
				record.setMachineId(machineId);
				record.setProductId(productId);
				record.setPreorderCapacity(0);
				this.preorderRecordDAO.add(record);
			}
			
			// step 4, calculate real price from applied policy of userId
			//TODO
			
			list.add(pd);
		}

		return list;
	}
}
