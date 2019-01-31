package com.osetrova.databaselocalizationtask.service;

import com.osetrova.databaselocalizationtask.model.Item;
import com.osetrova.databaselocalizationtask.model.Locale;
import com.osetrova.databaselocalizationtask.model.dto.ItemInfo;
import com.osetrova.databaselocalizationtask.model.dto.RequestItemParam;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class ItemInfoService {

    private AttributeService attributeService;
    private ItemService itemService;
    private ItemTranslationService itemTranslationService;
    private AttributeTranslationService attributeTranslationService;
    private LocaleService localeService;

    public ItemInfo getItemInfo(RequestItemParam param) {
        Locale locale = localeService.findByType(param.getLocaleType());
        Item item = itemService.findByCode(param.getCode());

        return ItemInfo.builder()
                .itemName(itemTranslationService.findByLocaleAndItem(locale, item).getName())
                .attributesNames(getAttributesNames(item, locale))
                .build();
    }

    private List<String> getAttributesNames(Item item, Locale locale) {
        return attributeService.findAllByItem(item).stream()
                .map(attribute -> attributeTranslationService.findByLocaleAndAttribute(locale, attribute).getName())
                .collect(toList());
    }
}
