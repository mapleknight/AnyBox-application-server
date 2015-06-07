package com.anybox.model;

import com.anybox.utils.AnyboxUtils;

public class OrderWithPrice extends OrderDetail {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5535708564402220713L;
	
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
