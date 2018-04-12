package com.atuldwivedi.quickcart.component.item.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atuldwivedi.quickcart.component.item.ItemFeignClient;
import com.atuldwivedi.quickcart.component.item.domain.Item;

@Controller
@RequestMapping("/itms")
public class ItemController {

	@Autowired
	private ItemFeignClient itemFeignClient;

	@GetMapping(value = "/")
	public String showHomePage(Map<String, List<Item>> map) {
		Resources itemsRsrc = itemFeignClient.getItems();
		itemsRsrc.removeLinks();
		List<Item> items = new ArrayList<>(itemsRsrc.getContent());
//		Collection<> itemsC = itemsRsrc.getContent();
//		itemsC.
//		List<Item> items = null;
//		itemsC.forEach(it -> items = new ArrayList<Item>(it));

		map.put("items", items);
		return "items";
	}

}
