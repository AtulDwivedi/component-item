package com.atuldwivedi.quickcart.component.item.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atuldwivedi.quickcart.component.item.ItemFeignClient;
import com.atuldwivedi.quickcart.component.item.domain.Item;

@Controller
@RequestMapping("/itms")
public class ItemController {

	@Autowired
	private ItemFeignClient itemFeignClient;

	@GetMapping(value = "/")
	public String getItems(Map<String, List<Item>> map) {
		Resources itemsRsrc = itemFeignClient.getItems();
		itemsRsrc.removeLinks();
		List<Item> items = new ArrayList<>(itemsRsrc.getContent());

		map.put("items", items);
		return "items";
	}

	@GetMapping(value = "/add")
	public String showAddItemForm(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "add-item";
	}

	@PostMapping(value = "/add")
	public String processAddItem(@Valid @ModelAttribute("item") Item item, BindingResult bindingResult) {
		System.out.println(bindingResult.getAllErrors());
		System.out.println(itemFeignClient.createItem(item).getContent());
		List<Item> itm = new ArrayList<>(itemFeignClient.getItems(1L).getContent());
		System.out.println(itm);
		return "index";
	}

}
