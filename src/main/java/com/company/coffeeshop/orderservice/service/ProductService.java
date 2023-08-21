package com.company.coffeeshop.orderservice.service;

import com.company.coffeeshop.orderservice.dao.interfaces.IProductDao;
import com.company.coffeeshop.orderservice.dto.ProductDTO;
import com.company.coffeeshop.orderservice.model.Product;
import com.company.coffeeshop.orderservice.service.interfaces.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final IProductDao productDao;

    public ProductService(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void create(ProductDTO productDTO) {
        Product product = productDTO.toEntity();
        productDao.create(product);
    }

    @Override
    public ProductDTO getById(UUID id) {
        Product product = productDao.getById(id);
        return ProductDTO.fromEntity(product);
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = productDao.getAll();
        return products.stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ProductDTO productDTO) {
        Product product = productDTO.toEntity();
        productDao.update(product);
    }

    @Override
    public void delete(UUID id) {
        productDao.delete(id);
    }
}

