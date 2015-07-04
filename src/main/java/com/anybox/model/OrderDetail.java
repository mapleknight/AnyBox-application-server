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
@Table(name="ORDER_DETAIL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2489784316312930182L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="machine_id")
	private int machineId;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_number")
	private int productNumber;
	
	@Column(name="pickup_date")
	private Date pickupDate;
	
	@Column(name="picked_time")
	private Date pickedTime;
	
	// product info begin
	private double price;
	
	@Column(name="real_price")
	private double realPrice;
	
	private String picurl;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="category_id")
	private int categoryId;
	// product info end
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

	@JsonSerialize(using=DateSerializer.class)
	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getPickedTime() {
		return pickedTime;
	}

	public void setPickedTime(Date pickedTime) {
		this.pickedTime = pickedTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return AnyboxUtils.toString(this);
	}

}
