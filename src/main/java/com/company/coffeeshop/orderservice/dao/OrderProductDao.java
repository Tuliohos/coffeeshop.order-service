package com.company.coffeeshop.orderservice.dao;

import com.company.coffeeshop.orderservice.dao.interfaces.IOrderProductDao;
import com.company.coffeeshop.orderservice.dao.rowmapper.OrderProductRowMapper;
import com.company.coffeeshop.orderservice.model.OrderProduct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class OrderProductDao implements IOrderProductDao {

    private final JdbcTemplate jdbcTemplate;

    public OrderProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(OrderProduct orderProduct) {
        String sql = "INSERT INTO order_products (order_id, product_id, quantity) VALUES (?, ?, ?, ?)";
        update(sql,
                orderProduct.getOrder().getId(),
                orderProduct.getProduct().getId(),
                orderProduct.getQuantity());
    }

    @Override
    public List<OrderProduct> getByOrderId(UUID orderId) {
        String sql = "SELECT * FROM order_products WHERE order_id = ?";
        return jdbcTemplate.query(sql, new OrderProductRowMapper(), orderId);
    }

    @Override
    public List<OrderProduct> getByProductId(UUID orderId) {
        String sql = "SELECT * FROM order_products WHERE product_id = ?";
        return jdbcTemplate.query(sql, new OrderProductRowMapper(), orderId);
    }

    @Override
    public List<OrderProduct> getAll() {
        String sql = "SELECT * FROM order_products";
        return jdbcTemplate.query(sql, new OrderProductRowMapper());
    }

    @Override
    public void update(OrderProduct orderProduct) {
        String sql = "UPDATE order_products SET quantity = ? WHERE order_id = ? AND product_id = ?";
        update(sql,
                orderProduct.getQuantity(),
                orderProduct.getOrder().getId(),
                orderProduct.getProduct().getId());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM order_products WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private void update(String sql, Object... params) {
        jdbcTemplate.update(sql, params);
    }
}

