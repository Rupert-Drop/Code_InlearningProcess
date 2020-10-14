package cn.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * myDruid01：可以使用
 * 阿里巴巴的连接池：德鲁伊 Druid 工具类
 * druid的jar包1.1.10版本
 * druid数据库连接池工具类
 * 读取配置文件成功
 */
public class DruidUtils {
    // 1. 定义成员变量
    private static DataSource ds;

    static {
        try {
            //1. 加载配置文件druid.properties
            Properties pro = new Properties();
            InputStream is = DruidUtils.class.getClassLoader().getResourceAsStream("cn/util/druid.properties");
            pro.load(is);
//           测试 ：System.out.println("aaaa");
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取连接：直接从数据库连接池中获取连接
     * * 当连接池为空时返回null (ds.getConnection() = null)
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源方法， 此处重载调用三个参数的方法设置第一个参数为空即可
     *
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
         /* if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
        close(null, stmt, conn);
    }

    /**
     * 释放资源方法, 注意：最后打开的对象应当最先关闭
     * Statement是prepereStatement对象这父类，这里使用父类对象引用指向子类对象
     *
     * @param rs
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

    /**
     * 获取连接池方法
     */

    public static DataSource getDataSourse() {
        return ds;
    }
}
