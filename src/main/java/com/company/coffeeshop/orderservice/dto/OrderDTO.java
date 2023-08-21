package com.company.coffeeshop.orderservice.dto;

import com.company.coffeeshop.orderservice.enums.OrderStatus;
import com.company.coffeeshop.orderservice.model.Order;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class OrderDTO {
    private UUID id;
    private Double totalAmount;
    private Instant orderDate;
    private OrderStatus status;

    public static OrderDTO fromEntity(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setTotalAmount(order.getTotalAmount());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        return dto;
    }

    public Order toEntity() {
        Order order = new Order();
        order.setId(this.id);
        order.setTotalAmount(this.totalAmount);
        order.setOrderDate(this.orderDate);
        order.setStatus(this.status);
        return order;
    }
}

