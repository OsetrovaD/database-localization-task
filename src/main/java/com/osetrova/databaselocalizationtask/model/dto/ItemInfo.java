package com.osetrova.databaselocalizationtask.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ItemInfo {

    private String itemName;
    private List<String> attributesNames;
}
