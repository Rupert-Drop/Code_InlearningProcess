package jdbc;

import util.MySql;

import java.sql.*;

/**
 * 连接数据库时只需要使用MySql
 * 练习注解的创建和解析：Target
 * url =jdbc:mysql://localhost:3306/db?serverTimezone=UTC&useSSL=false
 * user=root
 * password=zbhqm139
 * driver=com.mysql.cj.jdbc.Driver
 * #mysql8版本的配置
 */

@MySql(URl = "jdbc:mysql://localhost:3306/db?serverTimezone=UTC&useSSL=false",
        User = "root", Password = "zbhqm139", Driver = "com.mysql.cj.jdbc.Driver")
public class MySqlUtilsDemo {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            Class<MySqlUtilsDemo> mySqlUtilsDemoClass = MySqlUtilsDemo.class;//
            MySql annotation = mySqlUtilsDemoClass.getAnnotation(MySql.class);//
            url = annotation.URl();
            user = annotation.User();
            password = annotation.Password();
            driver = annotation.Driver();
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
