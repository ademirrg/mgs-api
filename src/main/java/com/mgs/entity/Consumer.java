package com.mgs.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "consumer")
@Getter
@Setter
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    @Size(max = 50)
    private String name;

    @Column
    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Column
    @NotBlank
    @Size(max = 20)
    private String phone;

    @Column
    @NotBlank
    @Size(max = 200)
    private String address;

    @Column
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column
    @Size(max = 200)
    private String complement;
}
