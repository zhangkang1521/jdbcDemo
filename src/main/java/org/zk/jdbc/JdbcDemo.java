package org.zk.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 为什么写Class.forName这样奇怪的代码，主要是为了执行执行static代码块的
 * DriverManager.registerDriver(new Driver()); ，也就是往驱动list添加一个Driver，
 * 也就是教科书上的注册驱动。
 * 注：驱动版本5及以上不需要写，使用spi(service provider interface)技术
 * Created by zhangkang on 2017/1/4.
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.jdbc.Driver");
        //new Driver();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zk", "root", "123456");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select id,username from tb_user");
        while (rs.next()) {
            System.out.print(rs.getInt("id") + ", ");
            System.out.print(rs.getString("username"));
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
