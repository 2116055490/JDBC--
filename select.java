package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class select {
    public static void main(String[] args) {
        Connection root=null;
        Statement statement =null;
        ResultSet resultSet=null;
        try{
            // 1.注册驱动
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            // 2.获取连接
            String url="jdbc:mysql://127.0.0.1:3306/test02";
            root = DriverManager.getConnection(url, "root", "905274");
            // 3.获取传输状态
            statement = root.createStatement();
            // 4.执行sql语句
            String sql = "select * from book where author='李玉刚'";
            resultSet = statement.executeQuery(sql);
            // 5.获取结果遍历结果集
            System.out.println("id\tname\tauthor\tprices");
            while(resultSet.next()){
                String sid = resultSet.getString(1);
                String sname = resultSet.getString("name");
                String sauthor = resultSet.getString("author");
                String sprices = resultSet.getString(4);
                System.out.println(sid+"\t"+sname+"\t"+sauthor+"\t"+sprices);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            // 6.关闭连接
            try{
                if (resultSet!=null) resultSet.close();
                if (statement!=null) statement.close();
                if (root!=null) root.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
