package com.mgs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {
    VALID_FIELDS(400, "Problema de validação nos seguintes campos:\n");

    private Integer code;
    private String message;
}
