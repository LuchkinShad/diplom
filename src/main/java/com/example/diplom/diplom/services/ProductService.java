package com.example.diplom.diplom.services;

import com.example.diplom.diplom.models.Image;
import com.example.diplom.diplom.models.ManufacturerModel;
import com.example.diplom.diplom.models.ProductModel;
import com.example.diplom.diplom.repository.ImageRepository;
import com.example.diplom.diplom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageService imageService;

    public List<ProductModel> getAllProduct() {
        return productRepository.findAll();
    }

    public ProductModel saveProduct(ProductModel productModel, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        installingImagesInProduct(productModel, file1, file2, file3);
        return productRepository.save(productModel);
    }

    private void installingImagesInProduct(ProductModel productModel, MultipartFile file1, MultipartFile file2, MultipartFile file3)
            throws IOException {
        Image image1;
        Image image2;
        Image image3;

        List<Image> imageList = new ArrayList<>();
        if (file1.getSize() != 0)
        {
            image1 = fromFileToImage(file1);
            image1.setPreviewImage(true);
            productModel.setPreviewImageId(image1.getId());
            imageList.add(image1);
        }
        if (file2.getSize() != 0)
        {
            image2 = fromFileToImage(file2);
            image2.setPreviewImage(false);
            imageList.add(image2);
        }
        if (file3.getSize() != 0)
        {
            image3 = fromFileToImage(file3);
            image3.setPreviewImage(false);
            imageList.add(image3);
        }
    }

    private Image fromFileToImage(MultipartFile file) throws IOException
    {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        imageService.saveImage(image);
        return image;
    }
}
