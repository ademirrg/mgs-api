package com.mgs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class ConsumerDTO {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 20)
    private String phone;

    @NotBlank
    @Size(max = 200)
    private String address;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Size(max = 200)
    private String complement;

    @NotBlank
    @Size(max = 20)
    private String cpf;
}
