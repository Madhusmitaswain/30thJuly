package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Idao.IItemDao;
import com.app.Iservice.IItemService;
import com.app.model.Item;
@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Override
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}

	@Override
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}
}
