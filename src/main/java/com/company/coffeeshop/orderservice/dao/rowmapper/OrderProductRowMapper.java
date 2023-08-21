package com.company.coffeeshop.orderservice.dao.rowmapper;

import com.company.coffeeshop.orderservice.model.Order;
import com.company.coffeeshop.orderservice.model.OrderProduct;
import com.company.coffeeshop.orderservice.model.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class OrderProductRowMapper implements RowMapper<OrderProduct> {

    @Override
    public OrderProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        OrderProduct orderProduct = new OrderProduct();

        Order order = new Order();
        order.setId(UUID.fromString(rs.getString("order_id")));
        orderProduct.setOrder(order);

        Product product = new Product();
        product.setId(UUID.fromString(rs.getString("product_id")));
        orderProduct.setProduct(product);

        orderProduct.setQuantity(rs.getInt("quantity"));

        return orderProduct;
    }
}

