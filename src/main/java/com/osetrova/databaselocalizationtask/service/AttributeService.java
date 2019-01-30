package com.osetrova.databaselocalizationtask.service;

import com.osetrova.databaselocalizationtask.model.Attribute;
import com.osetrova.databaselocalizationtask.model.Item;
import com.osetrova.databaselocalizationtask.repository.AttributeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AttributeService {

    private AttributeRepository repository;

    public List<Attribute> findAllByItem(Item item) {
        return repository.findAllByItems(item);
    }
}
