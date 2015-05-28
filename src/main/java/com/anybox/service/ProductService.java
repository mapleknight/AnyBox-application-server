package com.anybox.service;

import java.util.List;

import com.anybox.model.Product;
import com.anybox.model.ProductWithDetail;

public interface ProductService extends BasicService<Product> {

	List<ProductWithDetail> listWithDetail(int machineId, int userId, String date);

}
