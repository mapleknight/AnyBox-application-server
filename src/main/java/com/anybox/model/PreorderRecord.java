package com.anybox.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.anybox.utils.AnyboxUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name="PREORDER_RECORD")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PreorderRecord  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8262854396918300042L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	@Column(name="machine_id")
	private int machineId;
	
	@Column(name="product_id")
	private int productId;
	
	private int capacity;
	
	@Column(name="preorder_capacity")
	private int preorderCapacity;

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPreorderCapacity() {
		return preorderCapacity;
	}

	public void setPreorderCapacity(int preorderCapacity) {
		this.preorderCapacity = preorderCapacity;
	}
	
	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
