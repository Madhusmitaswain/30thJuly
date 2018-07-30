package com.app.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Idao.ICustomerDao;
import com.app.Iservice.ICustomerService;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.Order;
@Service
public class CustomerServiceImpl implements ICustomerService {
	
    @Autowired
	private ICustomerDao dao;

	@Override
	public int saveCustomer(Customer c) {
		return dao.saveCustomer(c);
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> custs=dao.getAllCustomer();
		Collections.sort(custs,new Comparator<Customer>()
				{
			@Override
			public int compare(Customer c1,Customer c2)
			{
				return c1.getCustId() - c2.getCustId();
			}
				});
		return custs;
		
	}

	@Override
	public void updateCustomer(Customer c) {
      dao.updateCustomer(c);		
	}

	@Override
	public void deleteCustomer(int c) {
		dao.deleteCustomer(c);
	}

	@Override
	public Customer getCustomerById(int custId) {
		return dao.getCustomerById(custId);
	}

	@Override
	public List<Object[]> getcusCountByLocName() {
		return dao.getcusCountByLocName();
	}

	@Override
	public List<Object[]> getCustomerTypeAndCount() {
		return dao.getCustomerTypeAndCount();
	}

	

	@Override
	public Customer getCustomerByEmail(String email) {
		return dao.getCustomerByEmail(email);
	}

	@Override
	public List<Item> getCustSellerItems(int custId) {
		return dao.getCustSellerItems(custId);
	}

	@Override
	public List<Order> getCustOrderByCustId(int custId) {
		return dao.getCustOrderByCustId(custId);
	}

	
}
