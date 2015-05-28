package com.anybox.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class ProductWithDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8895919841095466524L;

	private Product product;
	
	private double realPrice;
	
	private int amount;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
