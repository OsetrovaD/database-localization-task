package com.osetrova.databaselocalizationtask.service;

import com.osetrova.databaselocalizationtask.model.Attribute;
import com.osetrova.databaselocalizationtask.model.AttributeTranslation;
import com.osetrova.databaselocalizationtask.model.Locale;
import com.osetrova.databaselocalizationtask.repository.AttributeTranslationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AttributeTranslationService {

    private AttributeTranslationRepository repository;

    public AttributeTranslation findByLocaleAndAttribute(Locale locale, Attribute attribute) {
        return repository.findByLocaleAndAttribute(locale, attribute).orElseThrow(RuntimeException::new);
    }
}
