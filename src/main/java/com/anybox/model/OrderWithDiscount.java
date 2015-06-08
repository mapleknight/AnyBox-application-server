package com.anybox.model;

import com.anybox.utils.AnyboxUtils;

public class OrderWithDiscount extends OrderDetail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5535708564402220713L;
	
	private double discount;

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
