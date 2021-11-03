package com.company;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception{
        Connection root= null;
        Statement statement= null;
        try{
            // 1.注册驱动
            DriverManager.registerDriver(new Driver());
            // 2.获取链接
            root = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test02", "root", "905274");
            // 3.创建传输状态
            statement = root.createStatement();
            // 4.执行sql语句
            String sql = "update book set author='王二郎' where id=5";
            int i = statement.executeUpdate(sql);
            System.out.println(i>0? "更改成功": "更改失败");
            // 5.查询并遍历结果集
            // 6.关闭连接
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if (statement != null){
                    statement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            try{
                if (root != null){
                    root.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
