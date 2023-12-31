package com.ada.MeuPrimeiroProjeto.repository;

import com.ada.MeuPrimeiroProjeto.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    @Query(value = "SELECT * FROM ORDERS WHERE USER_ID = :userId", nativeQuery = true)
    List<Order> findAllByUser(Integer userId);


    @Query(value = "SELECT order FROM Order order JOIN order.products product WHERE product.id = :productId")
    List<Order> findAllByProduct(Integer productId);

    // O exemplo de query abaixo foi substituido pela query acima, na qual é utilizada um JPQL cuja chamada será feita direta no objeto da classe Order e nao mais de order
    //@Query(value = "SELECT o.* FROM orders o JOIN orders_products op ON o.id = op.order_id WHERE op.products_id = :productId", nativeQuery = true)
    //List<Order> findAllByProduct(Integer productId);



 }
