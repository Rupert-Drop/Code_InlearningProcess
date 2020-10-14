package util;

import java.sql.*;

/**
 * MySQL工具类
 * 功能：连接数据库
 * 依赖：1.利用注解传递数据库信息，
 * 2.搭配MySql注解文件使用
 */
@MySql(URl = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC&useSSL=false",
        User = "root", Password = "zbhqm139", Driver = "com.mysql.cj.jdbc.Driver")
public class MySqlUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {//解析注解，获取注解中传递的值
        try {
            Class<MySqlUtils> mySqlUtilsClass = MySqlUtils.class;//获取当前类的字节码对象
            MySql annotation = mySqlUtilsClass.getAnnotation(MySql.class);//获取注解内容Annotation：注解，解释
            //调用注解中的属性/方法
            url = annotation.URl();
            user = annotation.User();
            password = annotation.Password();
            driver = annotation.Driver();
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
        System.out.println(driver);
    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     *
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
