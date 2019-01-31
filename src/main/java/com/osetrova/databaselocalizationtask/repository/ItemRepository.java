package com.osetrova.databaselocalizationtask.repository;

import com.osetrova.databaselocalizationtask.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemRepository extends CrudRepository<Item, Long> {

    Optional<Item> findByCode(Integer code);
}
