/*
 * Products.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.productcatalogservice.entity;

import com.b2b.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Products.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products extends BaseEntity {
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;

    @Column(name = "discount_price")
    private BigDecimal discountPrice;

    @Column(name = "brand_id")
    private String brandId;

    @OneToMany(mappedBy = "product")
    List<ProductCategory> productCategory;

}
