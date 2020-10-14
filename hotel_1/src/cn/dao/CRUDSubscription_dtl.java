package cn.dao;

import cn.domain.Subscription;
import cn.domain.Subscription_dtl;
import cn.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * 功能：完成对Subscription_dtl表的增删改查
 */
public class CRUDSubscription_dtl {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSourse());

    public static void main(String[] args) {
        Subscription subscription = new Subscription();
        subscription.setNo(2015);
        CRUDSubscription_dtl crud = new CRUDSubscription_dtl();
//        crud.checkBySid(subscription);
    }

    /**
     * 方法一：
     * 返回一个map集合，此处最优的选择
     *
     * @param sid
     * @return
     */
    public Map<String, Object> checkBySid(String sid) {
        /*通过订单的sid获取订单明细，*/
        String sql = "select * from subscription_dtl where sid= ?";
        Map<String, Object> subscription_dtl = template.queryForMap(sql, sid);
//        System.out.println(subscription_dtl);
        return subscription_dtl;

    }

    /**
     * 方法二：
     * 返回一个list集合，此处可优化，使用方法一
     *
     * @param sid
     * @return
     */
    public List<Subscription_dtl> checkBySsid(String sid) {
        String sql = "select * from subscription_dtl where sid= ?";
        List<Subscription_dtl> list = template.query(sql, new BeanPropertyRowMapper<Subscription_dtl>(Subscription_dtl.class), sid);
        return list;
    }

    public void delet(String sid) {
        String sql = "delete from subscription_dtl where sid = ?";
        template.update(sql, sid);
    }

}
