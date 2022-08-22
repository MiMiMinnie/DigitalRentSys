package com.south.repository.impl;

import com.south.entity.Product;
import com.south.entity.ProductCase;
import com.south.repository.ProductRepository;
import com.south.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAll(int index, int limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select * from product,productcase where product.productcaseid = productcase.id limit ?,?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,index);
            preparedStatement.setInt(2,limit);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
//                ProductCase productCase = new ProductCase(resultSet.getInt(9),resultSet.getString(10));
//                Product product = new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(6),bookCase);
                list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5),resultSet.getDouble(6),new ProductCase(resultSet.getInt(9),resultSet.getString(10))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return list;
    }

    @Override
    public int count() {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from product,productcase where product.productcaseid = productcase.id";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int count=0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,resultSet);
        }
        return count;
    }
}
