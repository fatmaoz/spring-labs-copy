package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name="customer")
@NoArgsConstructor
public class Customer extends BaseEntity{
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

//    @OneToMany(mappedBy = "customer")
//    private List<Address> addressList;
}
