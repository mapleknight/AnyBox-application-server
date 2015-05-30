package com.anybox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.anybox.utils.AnyboxUtils;

@Entity
public class NotEnoughExceptionModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786788688620199145L;
	
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
	
	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
