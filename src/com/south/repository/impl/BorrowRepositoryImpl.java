package com.south.repository.impl;

import com.south.entity.Product;
import com.south.entity.Borrow;
import com.south.entity.User;
import com.south.repository.BorrowRepository;
import com.south.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepositoryImpl implements BorrowRepository {
    @Override
    public void insert(Integer productid, Integer userid, String borrowtime, String returntime, Integer adminid, Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "insert into borrow(productid,userid,borrowtime,returntime,state) values(?,?,?,?,0)";
        PreparedStatement preparedStatement = null;
        try {
            //重复的内容后续会有框架代替
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,productid);
            preparedStatement.setInt(2,userid);
            preparedStatement.setString(3,borrowtime);
            preparedStatement.setString(4,returntime);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,preparedStatement,null);
        }
    }

    @Override
    public List<Borrow> findAllByUserId(Integer id,Integer index,Integer limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.lessor,b.manufacturer,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state from product b,borrow br,user r where userid = ? and b.id = br.productid and br.userid = r.id limit ?,?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //定义在外面扩大作用域
        List<Borrow> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.setInt(2,index);
            statement.setInt(3,limit);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                //取出所有素材
//                int borrowid = resultSet.getInt(1);
//                String bookname = resultSet.getString(2);
//                String author = resultSet.getString(3);
//                String publish = resultSet.getString(4);
//                String borrowtime = resultSet.getString(5);
//                String returntime = resultSet.getString(6);
//                String readername = resultSet.getString(7);
//                String tel = resultSet.getString(8);
//                String cardid = resultSet.getString(9);
//                //封装
//                Product book = new Product(bookname,author,publish);
//                User reader = new User(readername,tel,cardid);
//                Borrow borrow = new Borrow(borrowid,book,reader,borrowtime,returntime);
                list.add(new Borrow(resultSet.getInt(1),
                        new Product(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)),
                        new User(resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return list;
    }

    @Override
    public int count(Integer userid) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from product b,borrow br,user r where userid = ? and b.id = br.productid and br.userid = r.id ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,userid);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return count;
    }

    @Override
    public List<Borrow> findAllByState(Integer state,Integer index,Integer limit) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select br.id,b.name,b.lessor,b.manufacturer,br.borrowtime,br.returntime,r.name,r.tel,r.cardid,br.state from product b,borrow br,user r where state=? and b.id = br.productid and br.userid = r.id limit ?,?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //定义在外面扩大作用域
        List<Borrow> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            statement.setInt(2,index);
            statement.setInt(3,limit);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                //取出所有素材
                list.add(new Borrow(resultSet.getInt(1),
                        new Product(resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)),
                        new User(resultSet.getString(7),resultSet.getString(8),resultSet.getString(9)),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getInt(10)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return list;
    }

    @Override
    public int countByState(Integer state) {
        Connection connection = JDBCTools.getConnection();
        String sql = "select count(*) from product b,borrow br,user r where state = ? and b.id = br.productid and br.userid = r.id ";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(connection,statement,resultSet);
        }
        return count;
    }

    @Override
    public void handle(Integer borrowId, Integer state, Integer adminId) {
        Connection connection = JDBCTools.getConnection();
        String sql = "update borrow set state = ?,adminid = ? where id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,state);
            statement.setInt(2,adminId);
            statement.setInt(3,borrowId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(connection,statement,null);
        }
    }
}
