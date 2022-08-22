package com.south.service.impl;

import com.south.entity.Product;
import com.south.entity.Borrow;
import com.south.repository.ProductRepository;
import com.south.repository.BorrowRepository;
import com.south.repository.impl.ProductRepositoryImpl;
import com.south.repository.impl.BorrowRepositoryImpl;
import com.south.service.ProductService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository = new ProductRepositoryImpl();
    private BorrowRepository borrowRepository = new BorrowRepositoryImpl();
    private final int LIMIT = 6;

    @Override
    public List<Product> findAll(int page) {
        int index = (page-1)*LIMIT;
        return productRepository.findAll(index,LIMIT);
    }

    @Override
    public int getPages() {
        int count = productRepository.count();
        int page = 0;
        if (count%LIMIT==0){
            page = count/LIMIT;
        }else{
            page = count / LIMIT + 1;
        }
        return page;
    }

    @Override
    public void addBorrow(Integer productid, Integer userid) {
        //借书时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String borrowTime = simpleDateFormat.format(date);
        //还书时间
        Calendar calendar = Calendar.getInstance();
        int dates = calendar.get(Calendar.DAY_OF_YEAR)+30;
        calendar.set(Calendar.DAY_OF_YEAR,dates);
        Date date2 = calendar.getTime();
        String returnTime = simpleDateFormat.format(date2);
        borrowRepository.insert(productid,userid,borrowTime,returnTime,null,0);
    }

    @Override
    public int getBorrowPages(Integer userid) {
        int count = borrowRepository.count(userid);
        int page = 0;
        if (count%LIMIT==0){
            page = count/LIMIT;
        }else{
            page = count / LIMIT + 1;
        }
        return page;
    }

    @Override
    public List<Borrow> findAllBorrowByUserId(Integer id,Integer page) {
        //业务：将 page 换算成 index , limit
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllByUserId(id,index,LIMIT);
    }

    @Override
    public List<Borrow> findAllBorrowByState(Integer state,Integer page) {
        int index = (page-1)*LIMIT;
        return borrowRepository.findAllByState(state,index,LIMIT);
    }

    @Override
    public int getBorrowPagesByState(Integer state) {
        int count = borrowRepository.countByState(state);
        int page = 0;
        if (count%LIMIT==0){
            page = count/LIMIT;
        }else{
            page = count / LIMIT + 1;
        }
        return page;
    }

    @Override
    public void handleBorrow(Integer borrowId, Integer state, Integer adminId) {
        borrowRepository.handle(borrowId,state,adminId);
    }

}
