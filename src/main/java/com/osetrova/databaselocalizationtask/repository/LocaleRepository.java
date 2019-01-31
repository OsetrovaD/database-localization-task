package com.osetrova.databaselocalizationtask.repository;

import com.osetrova.databaselocalizationtask.model.Locale;
import com.osetrova.databaselocalizationtask.model.LocaleType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocaleRepository extends CrudRepository<Locale, Short> {

    Optional<Locale> findByType(LocaleType type);
}
