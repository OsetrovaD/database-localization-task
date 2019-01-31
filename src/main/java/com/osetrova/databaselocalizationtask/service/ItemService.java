package com.osetrova.databaselocalizationtask.service;

import com.osetrova.databaselocalizationtask.model.Item;
import com.osetrova.databaselocalizationtask.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ItemService {

    private ItemRepository repository;

    public Item findByCode(Integer code) {
        return repository.findByCode(code).orElseThrow(RuntimeException::new);
    }
}
