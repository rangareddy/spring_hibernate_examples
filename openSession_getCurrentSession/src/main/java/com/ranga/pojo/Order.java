package com.ranga.pojo;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private long orderId;
	private String orderName;
	private Date orderDate;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(String orderName, Date orderDate) {
		super();
		this.orderName = orderName;
		this.orderDate = orderDate;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName
				+ ", orderDate=" + orderDate + "]";
	}

}
