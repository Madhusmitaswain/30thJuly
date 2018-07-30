package com.app.Idao;

import java.util.List;


import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.Order;

public interface ICustomerDao {
public int saveCustomer(Customer c);
public void updateCustomer(Customer c);
public void deleteCustomer(int c);
public Customer getCustomerById(int custId);
public List<Customer> getAllCustomer();
public List<Object[]> getcusCountByLocName();
public List<Object[]>getCustomerTypeAndCount();
public Customer getCustomerByEmail(String email);
List<Item> getCustSellerItems(int custId);
public List<Order> getCustOrderByCustId(int custId);



}
