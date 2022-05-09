package com.example.diplom.diplom.services;

import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    private AddressService addressService;

    public ManufacturerModel saveManufacturer(ManufacturerModel manufacturerModel){
        addressService.saveAddress(manufacturerModel.getAddressModel());
        return manufacturerRepository.save(manufacturerModel);
    }

    public Page<ManufacturerModel> getAllManufacturer(Pageable pageable){
        return manufacturerRepository.findAll(pageable);
    }

    public ManufacturerModel getManufacturerById(Long id){
        return manufacturerRepository.getById(id);
    }

    public void deleteManufacturerById(Long id){
        manufacturerRepository.deleteById(id);
    }
}
