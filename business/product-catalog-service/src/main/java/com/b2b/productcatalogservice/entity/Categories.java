/*
 * Categories.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.productcatalogservice.entity;

import com.b2b.core.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Categories.java
 *
 * @author Nguyen
 */
@Entity
@Table(name = "b2b_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categories extends BaseEntity {
    private String name;
    private String description;
    private int level;

    @OneToMany(mappedBy = "category")
    List<ProductCategory> productCategory;
}
