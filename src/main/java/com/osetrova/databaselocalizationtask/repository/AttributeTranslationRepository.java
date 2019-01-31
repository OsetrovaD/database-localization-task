package com.osetrova.databaselocalizationtask.repository;

import com.osetrova.databaselocalizationtask.model.Attribute;
import com.osetrova.databaselocalizationtask.model.AttributeTranslation;
import com.osetrova.databaselocalizationtask.model.Locale;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AttributeTranslationRepository extends CrudRepository<AttributeTranslation, Long> {

    Optional<AttributeTranslation> findByLocaleAndAttribute(Locale locale, Attribute attribute);
}
