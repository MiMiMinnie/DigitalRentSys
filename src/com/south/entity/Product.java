package com.south.entity;

public class Product {
    private Integer id;
    private String name;
    private String lessor;
    private String manufacturer;
    private Integer rentprice;
    private Double price;
    private ProductCase productCase;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLessor() {
        return lessor;
    }

    public void setLessor(String lessor) {
        this.lessor = lessor;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String publish) {
        this.manufacturer = manufacturer;
    }

    public Integer getRentprice() {
        return rentprice;
    }

    public void setRentprice(Integer pages) {
        this.rentprice = rentprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductCase getProductCase() {
        return productCase;
    }

    public void setProductCase(ProductCase productCase) {
        this.productCase = productCase;
    }

    public Product(Integer id, String name, String lessor, String manufacturer, Integer rentprice, Double price, ProductCase productCase) {
        this.id = id;
        this.name = name;
        this.lessor = lessor;
        this.manufacturer = manufacturer;
        this.rentprice = rentprice;
        this.price = price;
        this.productCase = productCase;
    }

    public Product(String name, String lessor, String manufacturer) {
        this.name = name;
        this.lessor = lessor;
        this.manufacturer = manufacturer;
    }
}
