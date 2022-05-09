package com.example.diplom.diplom.repository;

import com.example.diplom.diplom.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
