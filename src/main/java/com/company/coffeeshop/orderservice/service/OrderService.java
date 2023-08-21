package com.company.coffeeshop.orderservice.service;

import com.company.coffeeshop.orderservice.dao.interfaces.IOrderDao;
import com.company.coffeeshop.orderservice.dto.OrderDTO;
import com.company.coffeeshop.orderservice.model.Order;
import com.company.coffeeshop.orderservice.service.interfaces.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    private final IOrderDao orderDao;

    public OrderService(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void create(OrderDTO orderDTO) {
        Order order = orderDTO.toEntity();
        orderDao.create(order);
    }

    @Override
    public OrderDTO getById(UUID id) {
        Order order = orderDao.getById(id);
        return OrderDTO.fromEntity(order);
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> orders = orderDao.getAll();
        return orders.stream()
                .map(OrderDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(OrderDTO orderDTO) {
        Order order = orderDTO.toEntity();
        orderDao.update(order);
    }

    @Override
    public void delete(UUID id) {
        orderDao.delete(id);
    }
}

