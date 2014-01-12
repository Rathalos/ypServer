package com.yp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {

    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/yp";// 数据库地址
    private static final String DBUSER = "root";
    private static final String DBPASSWORD = "";

    protected Connection conn = null;
    public Statement st = null;
    public ResultSet rs = null;
    public PreparedStatement pst = null;

    // 打开连接
    public void open() {
        try {
            Class.forName(DBDRIVER);
            conn=DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 关闭连接
    public void close() {
        try {
            if(rs != null) {
                rs.close();
                rs = null;
            }
            if(st != null) {
                st.close();
                st = null;
            }
            if(pst != null) {
                pst.close();
                pst = null;
            }
            if(conn != null) {
                conn.close();
                conn = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
