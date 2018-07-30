package com.app.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.app.Idao.ICustomerDao;
import com.app.model.Customer;
import com.app.model.Item;
import com.app.model.Order;
import com.app.model.Vendor;
@Repository
public class CustomerDaoImpl implements ICustomerDao {
	@Autowired
   HibernateTemplate ht;
	public int saveCustomer(Customer c) {
		return (Integer) ht.save(c);
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customers = ht.loadAll(Customer.class);
		return customers;
	}

	@Override
	public void updateCustomer(Customer c) {
		ht.update(c);
		
	}

	@Override
	public void deleteCustomer(int c) {
		Customer customer = new Customer();
		customer.setCustId(c);
		ht.delete(customer);
		
	}

	@Override
	public Customer getCustomerById(int custId) {
		Customer customer = ht.get(Customer.class, custId);
		return customer;
	}

	@Override
	public List<Object[]> getcusCountByLocName() {
		String hql= " select loc.locName,count(loc.locName) " +
				" from com.app.model.Customer cus " +
				" inner join " +
				" cus.loc as loc " +
				" group by loc.locName ";
	List<Object[]> cust=ht.find(hql);
	return cust;
}

	@Override
	public List<Object[]> getCustomerTypeAndCount() {
String hql="select custType,count(custId) "+"from " +Customer.class.getName()+" group by custType";
		
		List<Object[]> custTypeCount=ht.find(hql);
		return custTypeCount;
	}

	@Override
	public Customer getCustomerByEmail(String email) {
			Customer cust=null;
			String hql="from "+Customer.class.getName()
					+" where custEmail=?";
			List<Customer> list=ht.find(hql, email);
			if(list!=null && list.size()>0){
				cust=list.get(0);
			}
			return cust;
		}

	
	@Override
	public List<Item> getCustSellerItems(int custId) {
		String hql="from "+Item.class.getName()
				+" where custId=?";
		@SuppressWarnings("unchecked")
		List<Item> items=ht.find(hql, custId);
		return items;
	}

	//@Override
		public List<Order> getCustOrderByCustId(int custId) {
			String hql="from Order where custId=?";
			return ht.find(hql, custId);
		}
}
