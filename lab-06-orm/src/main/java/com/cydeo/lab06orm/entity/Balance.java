package com.cydeo.lab06orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Balance extends BaseEntity{

    @OneToOne
    private Customer customer;
    private BigDecimal amount;
}
