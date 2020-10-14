package util.注解配置MySQL;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 功能：辅助MySqlUtils工具类的完成数据库连接的注解
 * mysql8版本的配置
 * url =jdbc:mysql://localhost:3306/db?serverTimezone=UTC&useSSL=false
 * user=root
 * password=zbhqm139
 * driver=com.mysql.cj.jdbc.Driver
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MySql {
    String URl();

    String User();

    String Password();

    String Driver();

}
