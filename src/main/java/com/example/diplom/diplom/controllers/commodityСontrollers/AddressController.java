package com.example.diplom.diplom.controllers.commodityСontrollers;

import com.example.diplom.diplom.models.AddressModel;
import com.example.diplom.diplom.services.AddressService;
import com.example.diplom.diplom.services.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private ErrorService errorService;

    @GetMapping("/address")
    public String getAllAdresses(Model model,
                                 @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<AddressModel> allAddresses = addressService.getAllAddresses(pageable);
        model.addAttribute("allAddresses", allAddresses);
        return "admin/address/address";
    }

    @GetMapping("/address/{id}/edit")
    public String addressEdit(@PathVariable(value = "id") long id,
                              Model model) {
        AddressModel addressModel = addressService.getAddressById(id);
        model.addAttribute("addressModel", addressModel);
        return "admin/address/address-edit";
    }

    @PostMapping("/address/{id}/edit")
    public String addressEdit(@PathVariable Long id,
                              @ModelAttribute("addressModel") AddressModel addressModel,
                              Model model){

        final List<ObjectError> objectErrorList = errorService.getErrors(addressModel);
        for (ObjectError objectError : objectErrorList) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        if (model.asMap().size() > 2)
        {
            return "admin/address/address-edit";
        }
        addressService.saveAddress(addressModel);
        return "redirect:/address";
    }

    @PostMapping("/address/{id}/remove")
    public String addressDelete(@PathVariable(value = "id") long id) {
        addressService.deleteAddressById(id);
        return "redirect:/address";
    }
}
