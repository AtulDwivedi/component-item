package com.atuldwivedi.quickcart.component.item;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atuldwivedi.quickcart.component.item.domain.Item;

@FeignClient(url = "localhost:8080", value = "items", path = "/items")
public interface ItemFeignClient {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Resources getItems();

}
