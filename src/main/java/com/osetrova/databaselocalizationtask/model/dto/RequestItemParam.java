package com.osetrova.databaselocalizationtask.model.dto;

import com.osetrova.databaselocalizationtask.model.LocaleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RequestItemParam {

    private Integer code;
    private LocaleType localeType;
}
