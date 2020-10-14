package cn.dao;

import cn.domain.Manager;
import cn.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 功能：完成对Manager表的增删改查
 * 完成对Manager表的查询，返回一个布尔值，判断是否允许登录
 * id                   int  auto_increment,
 * username             varchar(20)
 * pwd                  varchar(15)
 */

public class CRUDManager {

    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setUsername("aaa");
        manager.setPassword("456");
        CRUDManager crudManager = new CRUDManager();
        /* crudManager.check(manager);*/
        // crudManager.add();
        crudManager.change(manager);

    }

    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSourse());

    /**
     * 方法一;查询数据库并返回一个布尔值
     *
     * @param manager
     * @return true:表中存在
     * false:表中不存在
     */
    public boolean check(Manager manager) {
        boolean loginFlag = false;
        String sql = "select * from manager";
        List<Manager> list = template.query(sql, new BeanPropertyRowMapper<Manager>(Manager.class));
        for (Manager remanager : list) {
            // System.out.println("循环中："+remanager+manager);
            if (manager.getUsername().equals(remanager.getUsername()) && manager.getPassword().equals(remanager.getPassword())) {
//                System.out.println(manager+"__---___"+remanager);
                loginFlag = true;
//                System.out.println("匹配："+loginFlag);
            }
        }

//        System.out.println("我是"+loginFlag);
        return loginFlag;

    }

    /**
     * 方法二：
     * 插入一条数据
     * 辅助完成注册
     */
    public void add(Manager manager) {
        String sql = "insert into manager (username,password)values (?,?)";
        template.update(sql, manager.getUsername(), manager.getPassword());
    }

    /**
     * 更新数据库：辅助完成密码修改
     *
     * @param manager
     */
    public void change(Manager manager) {
      /*  System.out.println(manager.getUsername());
        System.out.println(manager.getPassword());*/
        String sql = "update manager set password = ? where username = ?";
        template.update(sql, manager.getPassword(), manager.getUsername());

    }

}
