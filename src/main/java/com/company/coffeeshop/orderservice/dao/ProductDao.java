package com.company.coffeeshop.orderservice.dao;

import com.company.coffeeshop.orderservice.dao.interfaces.IProductDao;
import com.company.coffeeshop.orderservice.dao.rowmapper.ProductRowMapper;
import com.company.coffeeshop.orderservice.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductDao implements IProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper;

    public ProductDao(JdbcTemplate jdbcTemplate, ProductRowMapper productRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productRowMapper = productRowMapper;
    }

    @Override
    public void create(Product product) {
        String sql = "INSERT INTO products (name, calories, description, price, type, is_vegan, is_gluten_free, image_url) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        update(sql,
                product.getName(),
                product.getCalories(),
                product.getDescription(),
                product.getPrice(),
                product.getType().name(),
                product.getIsVegan(),
                product.getIsGlutenFree(),
                product.getImageUrl());
    }

    @Override
    public Product getById(UUID id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, productRowMapper);
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name = ?, calories = ?, description = ?, price = ?, type = ?, is_vegan = ?, " +
                "is_gluten_free = ?, image_url = ? WHERE id = ?";

        update(sql,
                product.getName(),
                product.getCalories(),
                product.getDescription(),
                product.getPrice(),
                product.getType().name(),
                product.getIsVegan(),
                product.getIsGlutenFree(),
                product.getImageUrl(),
                product.getId());
    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM products WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private void update(String sql, Object... params) {
        jdbcTemplate.update(sql, params);
    }
}


