package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CartItem extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private Integer quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cart cart;
}
