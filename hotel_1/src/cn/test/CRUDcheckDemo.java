package cn.test;

import cn.domain.Manager;
import cn.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 增add删delete改change查check演示
 * 查找
 * 方法一：查询并返回一个map集合，里面仅封装了一条数据
 * 方法二：查询并返回一个list集合，里面以map集合形式封装了所有的数据，每一条数据是一个map集合
 * 方法三：查询并返回一个指定的JavaBean对象的集合
 * 方法四：插入方法
 * 方法五：删除方法
 * 方法六：更新方法
 */
public class CRUDcheckDemo {

    public static void main(String[] args) {
        CRUDcheckDemo cruDcheckDemo = new CRUDcheckDemo();

        /*//mapTest
        cruDcheckDemo.findMap();
*/
        /*//ListTest
        cruDcheckDemo.findList();*/
        //javaBeapTest
//        cruDcheckDemo.findJavaBean();

        cruDcheckDemo.addDdeom();
        //       cruDcheckDemo.delete();
        cruDcheckDemo.change();
    }

    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSourse());

    /**
     * 方法一：返回一个map集合，里面封装了一条数据
     */
    public void findMap() {
        String sql = "select * from manager where id= ?";
        Map<String, Object> map = template.queryForMap(sql, 4);
        //  System.out.println(map);
    }

    /**
     * 方法二:返回一个list集合，里面以map集合形式封装了所有的数据，每一条数据是一个map集合
     */
    public void findList() {
        String sql = "select * from manager";
        List<Map<String, Object>> list = template.queryForList(sql);
        //System.out.println(list);
    }

    /**
     * 方法三：返回一个指定的JavaBean对象的集合
     */
    public void findJavaBean() {
        String sql = "select * from manager";
        List<Manager> list = template.query(sql, new BeanPropertyRowMapper<Manager>(Manager.class));
       /* //循环遍历该集合
        for (Manager manager:list){
            System.out.println(manager);
            System.out.println(manager.getId());
            System.out.println(manager.getUsername());
        }*/
    }

    /**
     * 方法四：
     * 插入
     */
    public void addDdeom() {
        String sql = "insert into manager (username,password)values (?,?)";
        int count = template.update(sql, "ana", "123");
        /*System.out.println(sql);
        System.out.println(count);*/
    }

    /**
     * 方法五
     * 删除
     */
    public void delete() {
        String sql = "delete from manager where id = ?";
        template.update(sql, 3);
    }

    /**
     * 方法六
     * 修改
     */

    public void change() {
        String sql = "update manager set password = 111 where id = ?";
        template.update(sql, 1);

    }
}
