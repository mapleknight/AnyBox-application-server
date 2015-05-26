package com.anybox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name="CATEGORY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -965363582396036602L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	@Column(name="machine_id")
	private int machineId;
	
	@Column(name="tray_id")
	private int trayId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="preorder_capacity")
	private int preorderCapacity;
	
	@Column(name="free_capacity")
	private int freeCapacity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMachineId() {
		return machineId;
	}

	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}

	public int getTrayId() {
		return trayId;
	}

	public void setTrayId(int trayId) {
		this.trayId = trayId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getPreorderCapacity() {
		return preorderCapacity;
	}

	public void setPreorderCapacity(int preorderCapacity) {
		this.preorderCapacity = preorderCapacity;
	}

	public int getFreeCapacity() {
		return freeCapacity;
	}

	public void setFreeCapacity(int freeCapacity) {
		this.freeCapacity = freeCapacity;
	}
	
}
