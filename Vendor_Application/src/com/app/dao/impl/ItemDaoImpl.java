package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.Idao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveItem(Item item) {
		return (Integer)ht.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}
}
