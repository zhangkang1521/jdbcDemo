package org.zk.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zhangkang on 2017/1/4.
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zk", "root", "123456");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from tb_user");
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
