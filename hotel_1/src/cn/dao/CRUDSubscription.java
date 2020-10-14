package cn.dao;

import cn.domain.Manager;
import cn.domain.Subscription;
import cn.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 功能：完成对subscription表的增删改查
 * id                   int  auto_increment,
 * mid                  int                 --订单预订者
 * no                   int		--订单号
 * linkman              varchar(30) 		--联系人
 * email                varchar(50) 		--email
 * phone                varchar(18) 		--电话
 * status               varchar	       --订单状态，0：取消、1：确定、2：未生效
 * cretime              varchar 		--创建时间
 * remark               varchar(100),			--备注
 */
public class CRUDSubscription {

    public static void main(String[] args) {
        CRUDSubscription subscription = new CRUDSubscription();
        subscription.check();
        // subscription.delete();
        //subscription.change();
//        subscription.add();
        String no = "2001";
        subscription.checkByNo(no);

    }

    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSourse());

    /**
     * 方法一：查询subscription数据库并返回一个list集合；
     * 集合里面封装了subscription对象
     *
     * @return subscription对象
     */
    public List<Subscription> check() {
        String sql = "select * from Subscription";
        List<Subscription> list = template.query(sql, new BeanPropertyRowMapper<Subscription>(Subscription.class));
       /* for (Subscription subscription1:list){
            System.out.println(subscription1);
        }*/
        return list;
    }

    /**
     * 方法1.1
     * 根据用户名，及订单状态码查找
     *
     * @param manager
     * @return
     */
    public List<Subscription> checkByUsername(Manager manager) {
        String sql = "select * from subscription where linkman= ? AND status = 2";
        List<Subscription> list = template.query(sql, new BeanPropertyRowMapper<Subscription>(Subscription.class), manager.getUsername());
       /* for (Subscription subscription1:list){
            System.out.println(subscription1);
        }*/
        return list;

    }

    /**
     * 方法1.2
     * 查找历史订单
     *
     * @param manager
     * @return
     */
    public List<Subscription> checkHistory(Manager manager) {
        String sql = "select * from subscription where linkman= ? ";
        List<Subscription> list = template.query(sql, new BeanPropertyRowMapper
                <Subscription>(Subscription.class), manager.getUsername());
        return list;
    }

    /**
     * 方法1.3
     * 通过订单号no在subscription表中查找订单
     * 辅助完成修改信息功能
     *
     * @param no
     * @return subscription对象
     */
    public Subscription checkByNo(String no) {
        String sql = "select * from subscription where no= ? ";
        //  System.out.println("crudlist:"+list);
        return template.queryForObject(sql, new BeanPropertyRowMapper<Subscription>(Subscription.class), no);
    }

    /**
     * 方法二：删除
     */
    public void delete() {
        String sql = "delete from subscription where id = ?";
        template.update(sql, 2);
    }

    /**
     * 通过id删除
     *
     * @param id
     */
    public void deleteById(String id) {
        String sql = "delete from subscription where id = ?";
        template.update(sql, id);
//        System.out.println("我已执行");

    }

    /**
     * 方法三：修改
     */
    public void change() {
        String sql = "update subscription set linkman = '李四' where id = ?";
        template.update(sql, 1);
    }

    public void updateExit(String no, String name, String phone, String email) {
        String sql = "update subscription set linkman = ?,phone=?,email=? where no = ?";
        template.update(sql, name, phone, email, no);
    }

    /**
     * 方法四：添加
     */
    public void add() {
        String sql = "insert into subscription (linkman,phone)values (?,?)";
        template.update(sql, "王五", "12342321");
    }

}
