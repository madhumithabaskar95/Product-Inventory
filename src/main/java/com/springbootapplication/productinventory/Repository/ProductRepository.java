package com.springbootapplication.productinventory.Repository;

import com.springbootapplication.productinventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {


}
