package com.example.diplom.diplom.validators;

import com.example.diplom.diplom.models.AddressModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddressValidator implements Validator {


    @Override
    public boolean supports(Class<?> type) {
        return AddressModel.class.equals(type);
    }

    @Override
    public void validate(Object object, Errors errors) {
        final AddressModel addressModel = (AddressModel) object;

        if (addressModel.getCountry().isEmpty())
        {
            errors.reject("country", "Поле страна не должна быть пустым");
        }

        if (addressModel.getCity().isEmpty())
        {
            errors.reject("city", "Поле город не должно быть пустым");
        }

        if (addressModel.getStreet().isEmpty())
        {
            errors.reject("street", "Поле улица не должно быть пустым");
        }

        if (addressModel.getHouse() == null)
        {
            errors.reject("house", "Поле улица не должно быть пустым");
        }


        if (!addressModel.getCountry().isEmpty() && (addressModel.getCountry().length() < 3 || addressModel.getCountry().length() > 38))
        {
            errors.reject("country_length", "Поле страна не должно быть менее 3 и не более 38 символов");
        }

        if (!addressModel.getCity().isEmpty() && (addressModel.getCity().length() < 2 || addressModel.getCity().length() > 21))
        {
            errors.reject("city_length", "Поле город не должно быть менее 2 и не более 21 символов");
        }

        if (!addressModel.getStreet().isEmpty() && (addressModel.getStreet().length() < 3 || addressModel.getStreet().length() > 38))
        {
            errors.reject("street_length", "Поле улица не должно быть менее 3 и не более 38 символов");
        }

        if (addressModel.getHouse() != null && addressModel.getHouse().toString().length() > 7)
        {
            errors.reject("house_length", "Поле дом должно быть не более 7 символов");
        }
    }
}
