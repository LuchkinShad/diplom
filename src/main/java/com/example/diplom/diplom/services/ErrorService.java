package com.example.diplom.diplom.services;

import com.example.diplom.diplom.models.AddressModel;
import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.models.SupplierModel;
import com.example.diplom.diplom.validators.AddressValidator;
import com.example.diplom.diplom.validators.ManufacturerValidator;
import com.example.diplom.diplom.validators.SupplierValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.List;

@Component
public class ErrorService {

    @Autowired
    private AddressValidator addressValidator;

    @Autowired
    private ManufacturerValidator manufacturerValidator;

    @Autowired
    private SupplierValidator supplierValidator;

    public List<ObjectError> getErrors(AddressModel addressModel)
    {
        Errors errors = new BeanPropertyBindingResult(addressModel, "addressModel");
        addressValidator.validate(addressModel, errors);
        return errors.getAllErrors();
    }

    public List<ObjectError> getErrors(ManufacturerModel manufacturerModel)
    {
        Errors errors = new BeanPropertyBindingResult(manufacturerModel, "manufacturerModel");
        manufacturerValidator.validate(manufacturerModel, errors);
        return errors.getAllErrors();
    }

    public List<ObjectError> getErrors(SupplierModel supplierModel)
    {
        Errors errors = new BeanPropertyBindingResult(supplierModel, "supplierModel");
        supplierValidator.validate(supplierModel, errors);
        return errors.getAllErrors();
    }
}
