package com.company.coffeeshop.orderservice.dto;

import com.company.coffeeshop.orderservice.model.Order;
import com.company.coffeeshop.orderservice.model.OrderProduct;
import com.company.coffeeshop.orderservice.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductDTO {
    private UUID id;
    private UUID orderId;
    private UUID productId;
    private int quantity;

    public OrderProduct toEntity() {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setQuantity(quantity);

        Order order = new Order();
        order.setId(orderId);
        orderProduct.setOrder(order);

        Product product = new Product();
        product.setId(productId);
        orderProduct.setProduct(product);

        return orderProduct;
    }

    public static OrderProductDTO fromEntity(OrderProduct orderProduct) {
        return OrderProductDTO.builder()
                .orderId(orderProduct.getOrder().getId())
                .productId(orderProduct.getProduct().getId())
                .quantity(orderProduct.getQuantity())
                .build();
    }
}

