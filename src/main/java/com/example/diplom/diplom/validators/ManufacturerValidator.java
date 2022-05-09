package com.example.diplom.diplom.validators;

import com.example.diplom.diplom.models.ManufacturerModel;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ManufacturerValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ManufacturerModel.class.equals(type);
    }

    @Override
    public void validate(Object object, Errors errors) {

        final ManufacturerModel manufacturerModel = (ManufacturerModel) object;

        if (manufacturerModel.getName().isEmpty())
        {
            errors.reject("name", "Поле имя не должна быть пустым");
        }

        if (manufacturerModel.getInn() == null)
        {
            errors.reject("inn", "Поле ИНН не должно быть пустым");
        }

        if (manufacturerModel.getBic() == null)
        {
            errors.reject("bic", "Поле БИК не должно быть пустым");
        }

        if (manufacturerModel.getPhone() == null)
        {
            errors.reject("phone", "Поле номер не должно быть пустым");
        }


        if (!manufacturerModel.getName().isEmpty() && (manufacturerModel.getName().length() < 3 || manufacturerModel.getName().length() > 25))
        {
            errors.reject("name_length", "Поле имя не должно быть менее 3 и не более 25 символов");
        }

        if (manufacturerModel.getInn() != null && (manufacturerModel.getInn().toString().length() < 10 || manufacturerModel.getInn().toString().length() > 13))
        {
            errors.reject("inn_length", "Поле ИНН не должно быть менее 10 и не более 13 символов");
        }

        if (manufacturerModel.getBic() != null && manufacturerModel.getBic().toString().length() != 9)
        {
            errors.reject("bic_length", "Поле БИК должно быть 9 символов");
        }

        if (manufacturerModel.getPhone() != null && manufacturerModel.getPhone().toString().length() != 11)
        {
            errors.reject("phone_length", "Поле телефон должно быть 11 символов");
        }
    }
}
