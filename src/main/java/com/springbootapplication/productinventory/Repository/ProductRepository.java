package com.springbootapplication.productinventory.Repository;

import com.springbootapplication.productinventory.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {


}
