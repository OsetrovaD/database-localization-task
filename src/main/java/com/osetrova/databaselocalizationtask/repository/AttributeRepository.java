package com.osetrova.databaselocalizationtask.repository;

import com.osetrova.databaselocalizationtask.model.Attribute;
import com.osetrova.databaselocalizationtask.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AttributeRepository extends CrudRepository<Attribute, Long> {

    List<Attribute> findAllByItems(Item item);
}
