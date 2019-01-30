package com.osetrova.databaselocalizationtask.service;

import com.osetrova.databaselocalizationtask.model.Locale;
import com.osetrova.databaselocalizationtask.model.LocaleType;
import com.osetrova.databaselocalizationtask.repository.LocaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LocaleService {

    private LocaleRepository repository;

    public Locale findByType(LocaleType type) {
        return repository.findByType(type).orElseThrow(RuntimeException::new);
    }
}
