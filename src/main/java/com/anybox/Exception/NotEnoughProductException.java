package com.anybox.Exception;

import java.util.Date;

import com.anybox.model.NotEnoughExceptionModel;

public class NotEnoughProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5170178296505266515L;
	
	public NotEnoughProductException(Date date, int productId, int machineId) {
		super("Product amount not enough!");
		this.model = new NotEnoughExceptionModel();
		this.model.setDate(date);
		this.model.setProductId(productId);
		this.model.setMachineId(machineId);
	}
	
	private NotEnoughExceptionModel model;

	public NotEnoughExceptionModel getModel() {
		return model;
	}

	public void setModel(NotEnoughExceptionModel model) {
		this.model = model;
	}
	
}
