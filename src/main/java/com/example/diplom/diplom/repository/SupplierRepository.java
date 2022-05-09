package com.example.diplom.diplom.repository;

import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.models.SupplierModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {

    @Override
    Page<SupplierModel> findAll(Pageable pageable);
}
