package com.company.coffeeshop.orderservice.service;

import com.company.coffeeshop.orderservice.dao.interfaces.IOrderProductDao;
import com.company.coffeeshop.orderservice.dto.OrderProductDTO;
import com.company.coffeeshop.orderservice.model.OrderProduct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderProductService {

    private final IOrderProductDao orderProductDao;

    public OrderProductService(IOrderProductDao orderProductDao) {
        this.orderProductDao = orderProductDao;
    }

    public void create(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = orderProductDTO.toEntity();
        orderProductDao.create(orderProduct);
    }

    public List<OrderProductDTO> getByOrderId(UUID orderId) {
        List<OrderProduct> orderProducts = orderProductDao.getByOrderId(orderId);
        return orderProducts.stream()
                .map(OrderProductDTO::fromEntity)
                .toList();
    }

    public List<OrderProductDTO> getByProductId(UUID productId) {
        List<OrderProduct> orderProducts = orderProductDao.getByProductId(productId);
        return orderProducts.stream()
                .map(OrderProductDTO::fromEntity)
                .toList();
    }

    public List<OrderProductDTO> getAll() {
        List<OrderProduct> orderProducts = orderProductDao.getAll();
        return orderProducts.stream()
                .map(OrderProductDTO::fromEntity)
                .toList();
    }

    public void update(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = orderProductDTO.toEntity();
        orderProductDao.update(orderProduct);
    }

    public void delete(UUID id) {
        orderProductDao.delete(id);
    }
}


