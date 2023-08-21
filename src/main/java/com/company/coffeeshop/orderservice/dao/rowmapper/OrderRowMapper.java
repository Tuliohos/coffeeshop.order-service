package com.company.coffeeshop.orderservice.dao.rowmapper;

import com.company.coffeeshop.orderservice.enums.OrderStatus;
import com.company.coffeeshop.orderservice.model.Order;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId((UUID) resultSet.getObject("id"));
        order.setTotalAmount(resultSet.getDouble("total_amount"));
        order.setOrderDate(resultSet.getTimestamp("order_date").toInstant());
        order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
        return order;
    }
}

