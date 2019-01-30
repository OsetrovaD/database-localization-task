package com.osetrova.databaselocalizationtask.controller;

import com.osetrova.databaselocalizationtask.model.dto.ItemInfo;
import com.osetrova.databaselocalizationtask.model.dto.RequestItemParam;
import com.osetrova.databaselocalizationtask.service.ItemInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ItemInfoController {

    private ItemInfoService service;

    @GetMapping(value = "/item-info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ItemInfo getItemInfo(RequestItemParam param) {
        return service.getItemInfo(param);
    }
}
