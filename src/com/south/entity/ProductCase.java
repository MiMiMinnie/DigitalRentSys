package com.south.entity;

import java.util.List;

public class ProductCase {
    private Integer id;
    private String name;
//    private List<Product> books;


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

    public ProductCase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
