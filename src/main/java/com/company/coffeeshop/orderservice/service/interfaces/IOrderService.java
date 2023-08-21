package com.company.coffeeshop.orderservice.service.interfaces;

import com.company.coffeeshop.orderservice.dto.OrderDTO;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    void create(OrderDTO orderDTO);

    OrderDTO getById(UUID id);

    List<OrderDTO> getAll();

    void update(OrderDTO orderDTO);

    void delete(UUID id);
}
