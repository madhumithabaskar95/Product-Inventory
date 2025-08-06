package com.springbootapplication.productinventory.Mapper;

import com.springbootapplication.productinventory.Entity.ProductEntity;
import com.springbootapplication.productinventory.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDto(ProductEntity productEntity);

    ProductEntity toEntity(Product product);
}