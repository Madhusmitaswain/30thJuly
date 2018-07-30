package com.app.Iservice;

import java.util.List;

import com.app.model.Item;

public interface IItemService {
	public int saveItem(Item item);
	public List<Item> getAllItems();
}
