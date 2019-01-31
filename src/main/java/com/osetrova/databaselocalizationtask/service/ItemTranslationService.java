package com.osetrova.databaselocalizationtask.service;

import com.osetrova.databaselocalizationtask.model.Item;
import com.osetrova.databaselocalizationtask.model.ItemTranslation;
import com.osetrova.databaselocalizationtask.model.Locale;
import com.osetrova.databaselocalizationtask.repository.ItemTranslationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ItemTranslationService {

    private ItemTranslationRepository repository;

    public ItemTranslation findByLocaleAndItem(Locale locale, Item item) {
        return repository.findByLocaleAndItem(locale, item).orElseThrow(RuntimeException::new);
    }
}
