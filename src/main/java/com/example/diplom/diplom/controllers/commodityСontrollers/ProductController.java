package com.example.diplom.diplom.controllers.commodityСontrollers;


import com.example.diplom.diplom.models.ProductModel;
import com.example.diplom.diplom.services.ImageService;
import com.example.diplom.diplom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/products")
    public String getPageRegistration(Model model) {
        List<ProductModel> productsList = productService.getAllProduct();
        for (ProductModel productModel:productsList) {
            productModel.setImages(imageService.getByIdImage(productModel.getPreviewImageId()));
        }
        model.addAttribute("allProducts", productsList);
        return "products/product";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model) {
        model.addAttribute("productModel", new ProductModel());
        return "products/products-add";
    }

    @PostMapping("/product/add")
    public String addManufacturer(@RequestParam("file1") MultipartFile file1,
                                  @RequestParam("file2") MultipartFile file2,
                                  @RequestParam("file3") MultipartFile file3,
                                  @ModelAttribute("productModel") ProductModel productModel) throws IOException {
        productService.saveProduct(productModel, file1, file2, file3);
        return "redirect:/products";
    }
}
