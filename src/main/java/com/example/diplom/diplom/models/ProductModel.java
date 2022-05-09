package com.example.diplom.diplom.models;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "stockBalance")
    private String stockBalance;

    @Column(name = "dosage")
    private Integer dosage;

    @Column(name = "structure")
    private String structure;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierModel supplier;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private ManufacturerModel manufacturer;

    @Transient
    private Image images;

    private Long previewImageId;

    public ProductModel() {
    }

    public ProductModel(Long id, String title, String description, String stockBalance, Integer dosage, String structure, Long price, SupplierModel supplier, ManufacturerModel manufacturer, Long previewImageId, Image images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.stockBalance = stockBalance;
        this.dosage = dosage;
        this.structure = structure;
        this.supplier = supplier;
        this.manufacturer = manufacturer;
        this.price = price;
        this.previewImageId = previewImageId;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStockBalance() {
        return stockBalance;
    }

    public void setStockBalance(String stockBalance) {
        this.stockBalance = stockBalance;
    }

    public Integer getDosage() {
        return dosage;
    }

    public void setDosage(Integer dosage) {
        this.dosage = dosage;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    public ManufacturerModel getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerModel manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Image getImages() {
        return images;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public Long getPreviewImageId() {
        return previewImageId;
    }

    public void setPreviewImageId(Long previewImageId) {
        this.previewImageId = previewImageId;
    }
}
