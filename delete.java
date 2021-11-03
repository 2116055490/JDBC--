package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete {
    public static void main(String[] args) {

        String url="jdbc:mysql:///test02";
        String sql="delete from book where id=7";
        Connection root = null;
        Statement statement = null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            root = DriverManager.getConnection(url, "root", "905274");
            //2.获取连接
            //3.获取传输状态
            statement = root.createStatement();
            //4.执行sql语句
            int i = statement.executeUpdate(sql);
            System.out.println(i>0?"删除成功":"删除失败");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //5.关闭连接
            try{
                if (statement!=null) statement.close();
                if (root!=null) root.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
