package com.example.diplom.diplom.models;

import javax.persistence.*;

@Entity
public class ManufacturerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "bic")
    private Long bic;

    @Column(name = "phone")
    private Long phone;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel addressModel;


    public ManufacturerModel() {
    }

    public ManufacturerModel(Long id, String name, Long inn, Long bic, Long phone, AddressModel addressModel) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.bic = bic;
        this.phone = phone;
        this.addressModel = addressModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getBic() {
        return bic;
    }

    public void setBic(Long bic) {
        this.bic = bic;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public AddressModel getAddressModel() {
        return addressModel;
    }

    public void setAddressModel(AddressModel addressModel) {
        this.addressModel = addressModel;
    }
}
