package com.app.Idao;

import java.util.List;

import com.app.model.Order;

public interface IOrderDao {
	public int saveOrder(Order ord);
	public List<Order> getAllOrders();
}
