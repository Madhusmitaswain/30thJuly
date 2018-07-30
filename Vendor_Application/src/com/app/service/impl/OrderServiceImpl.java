package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Idao.IOrderDao;
import com.app.Iservice.IOrderService;
import com.app.model.Order;
@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
private IOrderDao dao;
	@Override
	public int saveOrder(Order ord) {
		return dao.saveOrder(ord);
	}

	@Override
	public List<Order> getAllOrders() {
		return dao.getAllOrders();
	}

}
