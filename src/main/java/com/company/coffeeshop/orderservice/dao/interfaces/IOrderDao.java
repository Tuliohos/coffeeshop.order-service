package com.company.coffeeshop.orderservice.dao.interfaces;

import com.company.coffeeshop.orderservice.model.Order;

import java.util.List;
import java.util.UUID;

public interface IOrderDao {
    void create(Order order);

    Order getById(UUID id);

    List<Order> getAll();

    void update(Order order);

    void delete(UUID id);
}
