package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Address;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Long> {
    //Write a derived query to get all address with a specific customer
    List<Address> findAllByCustomer(Customer customer);

    //Write a derived query to get address with a specific street
    Address findByStreet(String street);

    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findTop3ByCustomer_Email(String email);

    //Write a derived query to get all address with a specific customer and name
    List<Address> findAllByCustomerAndName(Customer customer, String name);

    //Write a derived query to list all address where the beginning of the street contains the keyword
    List<Address> findByStreetContaining(String keyword);

    //Write a JPQL query to get all address with a specific customerId
    @Query("SELECT a from Address a where a.customer.id = ?1")
    List<Address> retrieveAllAddressByCustomerId(@Param("id") Long id);

    @Query("SELECT a from Address a where a.customer.id = ?1")
    List<Address> retrieveAllAddressByCustomerId2( Long id);
}
