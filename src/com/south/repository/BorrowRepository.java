package com.south.repository;

import com.south.entity.Borrow;

import java.util.List;

public interface BorrowRepository {
    public void insert(Integer productid, Integer userid , String borrowtime,String returntime,Integer adminid ,Integer state);
    //封装租用记录
    public List<Borrow> findAllByUserId(Integer id,Integer index,Integer limit);
    public int count(Integer userid);
    public List<Borrow> findAllByState(Integer state,Integer index,Integer limit);
    public int countByState(Integer state);
    public void handle(Integer borrowId,Integer state,Integer adminId);
}
