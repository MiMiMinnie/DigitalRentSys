package com.south.service;

import com.south.entity.Product;
import com.south.entity.Borrow;

import java.util.List;

public interface ProductService {
    public List<Product> findAll(int page);
    public int getPages();
    public void addBorrow(Integer bookid, Integer userid);
    public int getBorrowPages(Integer userid);
    public List<Borrow> findAllBorrowByUserId(Integer id,Integer page);
    public List<Borrow> findAllBorrowByState(Integer state,Integer page);
    public int getBorrowPagesByState(Integer state);
    public void handleBorrow(Integer borrowId,Integer state, Integer adminId);
}

