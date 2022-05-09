package com.example.diplom.diplom.repository;

import com.example.diplom.diplom.models.AddressModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressModel, Long> {
    @Override
    Page<AddressModel> findAll(Pageable pageable);
}
