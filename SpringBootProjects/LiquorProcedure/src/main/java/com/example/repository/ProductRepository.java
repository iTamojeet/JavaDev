package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    @Procedure(procedureName = "UPDATE_PRODUCT_PRICE")
    void updateProductPrice(@Param("P_ID") Long id, @Param("P_PRICE") Double price);
}
