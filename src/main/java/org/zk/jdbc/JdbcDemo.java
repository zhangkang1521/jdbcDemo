package org.zk.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by zhangkang on 2017/1/4.
 */
public class JdbcDemo {
    private static Logger logger = LoggerFactory.getLogger(JdbcDemo.class);

    public static void main(String[] args) throws Exception {
        Class.forName("net.sf.log4jdbc.DriverSpy");
        Connection conn = DriverManager.getConnection("jdbc:log4jdbc:mysql://localhost:3306/zk", "root", "123456");
        PreparedStatement stmt = conn.prepareStatement("select * from tb_user where id=?");
        stmt.setInt(1, 3);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
//            System.out.print(rs.getInt("id") + ", ");
//            System.out.print(rs.getString("username"));
//            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
