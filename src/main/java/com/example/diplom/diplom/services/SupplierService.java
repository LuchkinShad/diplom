package com.example.diplom.diplom.services;

import com.example.diplom.diplom.models.SupplierModel;
import com.example.diplom.diplom.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private AddressService addressService;

    public SupplierModel saveSupplier(SupplierModel supplierModel){
        addressService.saveAddress(supplierModel.getAddressModel());
        return supplierRepository.save(supplierModel);
    }

    public Page<SupplierModel> getAllSupplier(Pageable pageable){
        return supplierRepository.findAll(pageable);
    }

    public SupplierModel getSupplierById(Long id){
        return supplierRepository.getById(id);
    }

    public void deleteSupplierById(Long id){
        supplierRepository.deleteById(id);
    }
}
