package com.company.coffeeshop.orderservice.dao.interfaces;

import com.company.coffeeshop.orderservice.model.OrderProduct;

import java.util.List;
import java.util.UUID;

public interface IOrderProductDao {
    void create(OrderProduct orderProduct);

    List<OrderProduct> getByOrderId(UUID orderId);

    List<OrderProduct> getByProductId(UUID orderId);

    List<OrderProduct> getAll();

    void update(OrderProduct orderProduct);

    void delete(UUID id);
}
