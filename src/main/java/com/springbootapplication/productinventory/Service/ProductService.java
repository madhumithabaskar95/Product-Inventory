package com.springbootapplication.productinventory.Service;

import com.springbootapplication.productinventory.Entity.ProductEntity;
import com.springbootapplication.productinventory.Mapper.ProductMapper;
import com.springbootapplication.productinventory.model.Product;
import com.springbootapplication.productinventory.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
ProductRepository productrepository;
    @Autowired
    ProductMapper productMapper;
    public List<Product> getAllProducts()
    {
        List<Product> allProductsList=new ArrayList<>();
        productrepository.findAll().forEach(entity ->allProductsList.add(productMapper.toDto(entity)));
        return allProductsList;
    }

    public Product getProductById(int productId)
    {

        return productrepository.findById(productId).map(productMapper::toDto).orElse(null);
    }

    public ResponseEntity<Void> addProduct(Product product)
    {
        ProductEntity productEntity=productMapper.toEntity(product);
         productrepository.save(productEntity);
         return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
