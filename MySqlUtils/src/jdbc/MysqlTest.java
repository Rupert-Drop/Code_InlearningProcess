package jdbc;

import util.注解配置MySQL.MySqlUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlTest {

    public static void main(String[] args) throws SQLException {
        MySqlUtils mySqlUtils = new MySqlUtils();
        Connection conn = mySqlUtils.getConnection();
        String sql = "select * from user where username = ? and password = ?";
        //连接数据库判断是否登录成功
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //3.获取执行sql的对象
        pstmt = conn.prepareStatement(sql);
        //给?赋值
        pstmt.setString(1, "aaa");
        pstmt.setString(2, "123");
        //4.执行查询,不需要传递sql
        rs = pstmt.executeQuery();
        //5.判断
        System.out.println(rs);

    }
}
