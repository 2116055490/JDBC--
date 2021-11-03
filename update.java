package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class update {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql:///test02","root","905274");
            //3.创建传输状态
            statement = connection.createStatement();
            //4.执行sql语句
            String sql="update book set author='小徐' where id=5";
            int i = statement.executeUpdate(sql);
            System.out.println(i>0?"更新成功":"更新失败");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            //5.关闭连接
            try{
                if (statement!=null) statement.close();
                if (connection!=null) connection.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
