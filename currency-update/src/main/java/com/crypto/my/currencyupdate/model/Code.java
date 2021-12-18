package com.crypto.my.currencyupdate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(name = "name_unique", columnNames = "name")})
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "code")
    private List<Price> prices;
}
