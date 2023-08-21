package com.company.coffeeshop.orderservice.model;

import com.company.coffeeshop.orderservice.enums.ProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity{

    @Id
    private UUID id;
    private String name;
    private Integer calories;
    private String description;
    private Double price;
    private ProductType type;
    private Boolean isVegan;
    private Boolean isGlutenFree;
    private String imageUrl;
}
