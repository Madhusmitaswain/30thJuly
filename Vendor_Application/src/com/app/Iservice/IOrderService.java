package com.app.Iservice;

import java.util.List;

import com.app.model.Order;

public interface IOrderService  {
	public int saveOrder(Order ord);
	public List<Order> getAllOrders();
}
