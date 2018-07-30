package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.Idao.IOrderDao;
import com.app.model.Order;
@Repository
public class OrderDaoImpl implements IOrderDao {
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveOrder(Order ord) {
		return (Integer)ht.save(ord);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return ht.loadAll(Order.class);
	}

}
