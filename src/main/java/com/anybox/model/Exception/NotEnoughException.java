package com.anybox.model.Exception;

import java.util.Date;

public class NotEnoughException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5170178296505266515L;
	
	public NotEnoughException(Date date, int productId, int machineId) {
		super("Product amount not enough!");
		this.date = date;
		this.productId = productId;
		this.machineId = machineId;
	}
	
	private Date date;
	
	private int productId;
	
	private int machineId;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

}
