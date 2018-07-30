package com.app.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class ItemUtil {
	public List<String> getItemModels(){
		return Arrays.asList("A","B","c");
	}
	public void addUiComponents(ModelMap map) {
		map.addAttribute("itemTypesUi", getItemModels());
	}
}
