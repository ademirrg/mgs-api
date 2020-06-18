package com.mgs.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cliente")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String address;
}
