package com.springbootapplication.productinventory.controller;
import com.springbootapplication.productinventory.api.ProductsApi;
import com.springbootapplication.productinventory.model.Product;
import com.springbootapplication.productinventory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements ProductsApi {
 @Autowired
ProductService productService;

    @Override
    public ResponseEntity<Product> productIdGet(Integer id) {
       Product product=productService.getProductById(id);
       if(product==null)
       {
           return ResponseEntity.notFound().build();
       }
       else return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<Product>> productsGet() {
        List<Product> productsList=productService.getAllProducts();
        return ResponseEntity.ok(productsList);
    }

    @Override
    public ResponseEntity<Void> productsPost(Product product) {
        return productService.addProduct(product);

    }
}
