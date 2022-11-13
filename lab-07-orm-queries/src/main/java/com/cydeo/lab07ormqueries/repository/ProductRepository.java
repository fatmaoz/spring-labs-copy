package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Category;
import com.cydeo.lab07ormqueries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByOrderByPriceDesc();

    //Write a derived query to get product by specific name
    Product findFirstByName(String productName);

    //Write a derived query to get product by specific category
    List<Product> findProductByCategoryListContaining(Category category);

    //Write a derived query to get count by price greater than specific amount
    int countProductByPriceGreaterThan(BigDecimal price);

    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product> findAllByQuantityIsGreaterThanEqual(int quantity);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(value = "select * from product p where p.price > ?1 and p.remaining_quantity < ?2", nativeQuery = true)
    List<Product> retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(BigDecimal price, int remainingQuantity);

    //Write a native query to get all product by specific categoryId
    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id = ?1", nativeQuery = true)
    List<Product> retrieveProductListByCategory(Long categoryId);

    //Write a native query to get all product by specific categoryId and price greater than specific amount
    @Query(value = "select * from product p join product_category_rel pl on pl.p_id = p.id where pl.c_id in(?1) " +
            " p.price > ?2", nativeQuery = true)
    List<Product> retrieveProductListByCategory(List<Long> categoryId, BigDecimal price);







}