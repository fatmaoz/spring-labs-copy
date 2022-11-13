package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.enums.CartState;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get count cart items
    Integer countAllBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findAllByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "select ci.* from cart_item ci join product p on p.id = ci.product_id" +
            " join cart c on c.id = ci.cart_id where p.id = ?1 and c.cart_state = ?2", nativeQuery = true)
    List<CartItem> retriveCartItemThatSold(Long productId, String cartState);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "select ci.* from cart_item ci join product p on p.id = ci.product_id" +
            " join cart c on c.id = ci.cart_id where p.id = ?1 and c.cart_state = ?2 and c.discount_id is null", nativeQuery = true)
    List<CartItem> retriveCartItemThatSoldWithOutDiscount(Long productId, String cartState);

    //Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(value = "select * from cart_item join cart c on c.id = cart_item.cart_id " +
            "         join discount d on d.id = c.discount_id" +
            " where c.cart_state = ?1 and d.discount_type = ?2",nativeQuery = true)
    List<CartItem> fetchCartItemByCartStateAndDiscountType(CartState cartState, DiscountType discountType);
}
