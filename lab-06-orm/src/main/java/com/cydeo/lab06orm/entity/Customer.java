package com.cydeo.lab06orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
