package com.anybox.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

import com.anybox.utils.AnyboxUtils;

@Entity
public class OrderInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8336885730629854087L;

	private Order order;

	private List<OrderDetail> detail;
	
	private String promoCode;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<OrderDetail> detail) {
		this.detail = detail;
	}
	
	public String getPromoCode() {
		return promoCode;
	}

	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}

	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
