package com.mgs.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "consumer")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consumer extends BaseAuditEntity {

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

    @Column
    private String email;

    @Column
    private String complement;

    @Column(updatable = false)
    private String cpf;
}
