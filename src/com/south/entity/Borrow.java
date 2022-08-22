package com.south.entity;

public class Borrow {
    private Integer id;
    //关联图书对象
    private Product product;
    //关联读者对象
    private User user;
    private String borrowTime;
    private String returnTime;
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Borrow(Integer id, Product product, User user, String borrowTime, String returnTime, Integer state) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.borrowTime = borrowTime;
        this.returnTime = returnTime;
        this.state = state;
    }
}
