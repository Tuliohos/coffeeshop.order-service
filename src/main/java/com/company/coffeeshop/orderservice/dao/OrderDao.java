package com.company.coffeeshop.orderservice.dao;

import com.company.coffeeshop.orderservice.dao.interfaces.IOrderDao;
import com.company.coffeeshop.orderservice.dao.rowmapper.OrderRowMapper;
import com.company.coffeeshop.orderservice.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderDao implements IOrderDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Order order) {
        String sql = "INSERT INTO orders (id, total_amount, order_date, status) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), order.getTotalAmount(), order.getOrderDate(), order.getStatus());
    }

    @Override
    public Order getById(UUID id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new OrderRowMapper(), id);
    }

    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE orders SET total_amount = ?, order_date = ?, status = ? WHERE id = ?";
        jdbcTemplate.update(sql, order.getTotalAmount(), order.getOrderDate(), order.getStatus(), order.getId());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
