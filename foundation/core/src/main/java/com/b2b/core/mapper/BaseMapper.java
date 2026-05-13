/*
 * BaseMapper.java
 *
 * Copyright (c) 2025 Nguyen. All rights reserved.
 * This software is the confidential and proprietary information of Nguyen.
 */

package com.b2b.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * BaseMapper.java
 *
 * @author Nguyen
 */
@Component
@Mapper(componentModel = "spring")
public interface BaseMapper<E, D> {
    D toDto(E entity);

    E toEntity(D dto);

    void updateEntityFromDto(D dto, @MappingTarget E entity);

    List<D> toDtoList(List<E> entityList);

    List<E> toEntityList(List<D> dtoList);
}
