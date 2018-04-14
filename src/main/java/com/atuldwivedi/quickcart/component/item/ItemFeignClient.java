package com.atuldwivedi.quickcart.component.item;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atuldwivedi.quickcart.component.item.domain.Item;

@FeignClient(url = "localhost:8080", value = "items", path = "/items")
public interface ItemFeignClient {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Resources getItems();
	
	@RequestMapping(value = "/{itemId}", method = RequestMethod.GET)
	public Resources getItems(@PathVariable("itemId") Long itemId);

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Resources createItem(Item item);

}
