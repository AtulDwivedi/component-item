package com.atuldwivedi.quickcart.component.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.atuldwivedi.quickcart.component.item.domain.Item;

@RepositoryRestResource(collectionResourceRel = "items", path = "items")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
