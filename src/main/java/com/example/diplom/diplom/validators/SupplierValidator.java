package com.example.diplom.diplom.validators;

import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.models.SupplierModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SupplierValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return SupplierModel.class.equals(type);
    }

    @Override
    public void validate(Object object, Errors errors) {

        final SupplierModel supplierModel = (SupplierModel) object;

        if (supplierModel.getName().isEmpty())
        {
            errors.reject("name", "Поле имя не должна быть пустым");
        }

        if (supplierModel.getInn() == null)
        {
            errors.reject("inn", "Поле ИНН не должно быть пустым");
        }

        if (supplierModel.getBic() == null)
        {
            errors.reject("bic", "Поле БИК не должно быть пустым");
        }

        if (supplierModel.getPhone() == null)
        {
            errors.reject("phone", "Поле номер не должно быть пустым");
        }


        if (!supplierModel.getName().isEmpty() && (supplierModel.getName().length() < 3 || supplierModel.getName().length() > 25))
        {
            errors.reject("name_length", "Поле имя не должно быть менее 3 и не более 25 символов");
        }

        if (supplierModel.getInn() != null && (supplierModel.getInn().toString().length() < 10 || supplierModel.getInn().toString().length() > 13))
        {
            errors.reject("inn_length", "Поле ИНН не должно быть менее 10 и не более 13 символов");
        }

        if (supplierModel.getBic() != null && supplierModel.getBic().toString().length() != 9)
        {
            errors.reject("bic_length", "Поле БИК должно быть 9 символов");
        }

        if (supplierModel.getPhone() != null && supplierModel.getPhone().toString().length() != 11)
        {
            errors.reject("phone_length", "Поле телефон должно быть 11 символов");
        }
    }
}
