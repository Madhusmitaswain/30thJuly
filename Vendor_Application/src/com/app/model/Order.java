package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_tab")
public class Order {
	@Id
	@Column(name="order_id")
	private int orderId;
	@Column(name="order_code")
	private String orderCode;
	@Column(name="item_code")
	private String itemCode;
	private double cost;
	public Order() {
		super();
	}
	public Order(int orderId) {
		super();
		this.orderId = orderId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCode=" + orderCode + ", itemCode=" + itemCode + ", cost=" + cost
				+ "]";
	}
	
}
