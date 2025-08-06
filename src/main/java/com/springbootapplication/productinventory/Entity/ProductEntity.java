package com.springbootapplication.productinventory.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name="Products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;

    private String supplierId;

    private String skuId;

    private String productCategory;

    private Integer quantity;

    private LocalDate createdAt = null;

    private LocalDate updatedAt = null;


}
