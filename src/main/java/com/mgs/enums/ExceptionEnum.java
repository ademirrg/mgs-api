package com.mgs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionEnum {
    VALID_FIELDS(400, "Problema de validação nos seguintes campos:\n"),
    EMAIL_ALREADY_EXIST(400, "E-mail já cadastrado em nossa base."),
    CPF_ALREADY_EXIST(400, "CPF já cadastrado em nossa base.");

    private Integer code;
    private String message;
}
