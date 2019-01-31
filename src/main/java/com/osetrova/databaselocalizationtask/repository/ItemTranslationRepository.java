package com.osetrova.databaselocalizationtask.repository;

import com.osetrova.databaselocalizationtask.model.Item;
import com.osetrova.databaselocalizationtask.model.ItemTranslation;
import com.osetrova.databaselocalizationtask.model.Locale;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ItemTranslationRepository extends CrudRepository<ItemTranslation, Long> {

    Optional<ItemTranslation> findByLocaleAndItem(Locale locale, Item item);
}
