package com.example.diplom.diplom.services;

import com.example.diplom.diplom.models.AddressModel;
import com.example.diplom.diplom.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressModel saveAddress(AddressModel addressModel){
        AddressModel addressModelSaving = addressRepository.save(addressModel);
        return addressModelSaving;
    }

    public Page<AddressModel> getAllAddresses(Pageable pageable){
        return addressRepository.findAll(pageable);
    }

    public AddressModel getAddressById(Long id){
        return addressRepository.getById(id);
    }

    public void deleteAddressById(Long id){
        addressRepository.deleteById(id);
    }
}
