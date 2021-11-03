package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static void main(String[] args) {
        Connection root=null;
        Statement statement = null;
        try{
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2.获取连接
            String url="jdbc:mysql://127.0.0.1:3306/test02";
            root = DriverManager.getConnection(url, "root", "905274");
            // 3.获取传输状态
            statement = root.createStatement();
            // 4.执行sql语句
            String sql = "insert into book values(7,'新贵妃醉酒','李玉刚',36)";
            int i = statement.executeUpdate(sql);
            System.out.println(i>0?"插入成功":"插入失败");
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭连接
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (root!=null){
                try {
                    root.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
