package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.Iservice.IItemService;
import com.app.model.Item;
import com.app.model.Vendor;
import com.app.util.ItemUtil;

@Controller
public class ItemController {
@Autowired
private IItemService service;
/*@Autowired
private ItemUtil util;*/
@RequestMapping("/regitem")
public String getPage(ModelMap map){
	//util.addUiComponents(map);
	return "ItemReg";
	
}
@RequestMapping(value = "/insertItem", method = RequestMethod.POST)
public String saveItem(@ModelAttribute("item") Item item, ModelMap map) {
	int itemId = service.saveItem(item);
	String m = "ITEM created:" + itemId;
	map.addAttribute("message", m);
	return "ItemReg";
}
}
