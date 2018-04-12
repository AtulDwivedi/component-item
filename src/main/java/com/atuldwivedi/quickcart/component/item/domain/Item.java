package com.atuldwivedi.quickcart.component.item.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	private String itemName;

	private String itemDescription;

	private Double itemPrice;
}
