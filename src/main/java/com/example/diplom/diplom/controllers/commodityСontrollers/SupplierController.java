package com.example.diplom.diplom.controllers.commodityСontrollers;

import com.example.diplom.diplom.models.SupplierModel;
import com.example.diplom.diplom.services.ErrorService;
import com.example.diplom.diplom.services.SupplierService;
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
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private ErrorService errorService;

    @GetMapping("/supplier")
    public String getAllSupplier(Model model,
                                 @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<SupplierModel> allSupplier = supplierService.getAllSupplier(pageable);
        model.addAttribute("allSupplier", allSupplier);
        return "admin/supplier/supplier";
    }

    @GetMapping("/supplier/{id}/edit")
    public String supplierEdit(@PathVariable(value = "id") long id,
                                   Model model) {
        SupplierModel supplierModel = supplierService.getSupplierById(id);
        model.addAttribute("supplierModel", supplierModel);
        return "admin/supplier/supplier-edit";
    }

    @GetMapping("/supplier/add")
    public String addSupplier(Model model){
        model.addAttribute("supplierModel", new SupplierModel());
        return "admin/supplier/supplier-add";
    }

    @PostMapping("/supplier/add")
    public String addSupplier(@ModelAttribute("supplierModel") SupplierModel supplierModel,
                                  Model model){
        final List<ObjectError> objectErrorListSupplier = errorService.getErrors(supplierModel);
        final List<ObjectError> objectErrorListAddress = errorService.getErrors(supplierModel.getAddressModel());
        for (ObjectError objectError : objectErrorListAddress) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        for (ObjectError objectError : objectErrorListSupplier) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        if (model.asMap().size() > 2)
        {
            return "admin/supplier/supplier-add";
        }
        supplierService.saveSupplier(supplierModel);
        return "redirect:/supplier";
    }

    @PostMapping("/supplier/{id}/edit")
    public String addressEdit(@PathVariable Long id,
                              @ModelAttribute("supplierModel") SupplierModel supplierModel,
                              Model model){

        final List<ObjectError> objectErrorList = errorService.getErrors(supplierModel);
        for (ObjectError objectError : objectErrorList) {
            model.addAttribute(objectError.getCode(), objectError.getDefaultMessage());
        }
        if (model.asMap().size() > 2)
        {
            return "admin/supplier/supplier-edit";
        }
        supplierService.saveSupplier(supplierModel);
        return "redirect:/supplier";
    }

    @PostMapping("/supplier/{id}/remove")
    public String supplierDelete(@PathVariable(value = "id") long id) {
        supplierService.deleteSupplierById(id);
        return "redirect:/supplier";
    }
}
