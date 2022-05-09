package com.example.diplom.diplom.repository;

import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.models.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<ManufacturerModel, Long> {

    @Override
    Page<ManufacturerModel> findAll(Pageable pageable);
}
