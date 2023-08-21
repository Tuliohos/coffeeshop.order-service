package com.company.coffeeshop.orderservice.service.interfaces;

import com.company.coffeeshop.orderservice.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    void create(ProductDTO productDTO);

    ProductDTO getById(UUID id);

    List<ProductDTO> getAll();

    void update(ProductDTO productDTO);

    void delete(UUID id);
}
