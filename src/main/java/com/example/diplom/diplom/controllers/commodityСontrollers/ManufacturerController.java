package com.example.diplom.diplom.controllers.commodityСontrollers;

import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.services.ErrorService;
import com.example.diplom.diplom.services.ManufacturerService;
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
public class ManufacturerController {

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ErrorService errorService;

    @GetMapping("/manufacturer")
    public String getAllManufacturer(Model model,
                                     @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<ManufacturerModel> allManufacturer = manufacturerService.getAllManufacturer(pageable);
        model.addAttribute("allManufacturer", allManufacturer);
        return "admin/manufacturer/manufacturer";
    }

    @GetMapping("/manufacturer/add")
    public String addManufacturer(Model model){
        model.addAttribute("manufacturerModel", new ManufacturerModel());
        return "admin/manufacturer/manufacturer-add";
    }

    @PostMapping("/manufacturer/add")
    public String addManufacturer(@ModelAttribute("manufacturerModel") ManufacturerModel manufacturerModel,
                              Model model){
        final List<ObjectError> objectErrorListManufacturer = errorService.getErrors(manufacturerModel);
        final List<ObjectError> objectErrorListAddress = errorService.getErrors(manufacturerModel.getAddressModel());
        for (ObjectError objectError : objectErrorListAddress) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        for (ObjectError objectError : objectErrorListManufacturer) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        if (model.asMap().size() > 2)
        {
            return "admin/manufacturer/manufacturer-add";
        }
        manufacturerService.saveManufacturer(manufacturerModel);
        return "redirect:/manufacturer";
    }

    @GetMapping("/manufacturer/{id}/edit")
    public String manufacturerEdit(@PathVariable(value = "id") long id,
                              Model model) {
        ManufacturerModel manufacturerModel = manufacturerService.getManufacturerById(id);
        model.addAttribute("manufacturerModel", manufacturerModel);
        return "admin/manufacturer/manufacturer-edit";
    }

    @PostMapping("/manufacturer/{id}/edit")
    public String addressEdit(@PathVariable Long id,
                              @ModelAttribute("manufacturerModel") ManufacturerModel manufacturerModel,
                              Model model){
        final List<ObjectError> objectErrorList = errorService.getErrors(manufacturerModel);
        for (ObjectError objectError : objectErrorList) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        if (model.asMap().size() > 2)
        {
            return "admin/manufacturer/manufacturer-edit";
        }
        manufacturerService.saveManufacturer(manufacturerModel);
        return "redirect:/manufacturer";
    }

    @PostMapping("/manufacturer/{id}/remove")
    public String manufacturerDelete(@PathVariable(value = "id") long id) {
        manufacturerService.deleteManufacturerById(id);
        return "redirect:/manufacturer";
    }
}
