package cn.dao;

import cn.domain.Member;
import cn.util.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * 尚无法操纵数据member表
 * 功能：完成对Member表的增删改查
 * id                   int not null auto_increment,
 * username             varchar(20) not null,
 * pwd                  varchar(15) not null,
 * name                 varchar(30),
 * email                varchar(50),
 * phone                varchar(18),
 * regtime              varchar
 */
public class CRUDMember {

    public static void main(String[] args) {
        CRUDMember member = new CRUDMember();
        // member.check();
        // member.add();
    }

    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSourse());

    public void check() {
        String sql = "select * from member";
        List<Member> list = template.query(sql, new BeanPropertyRowMapper<Member>(Member.class));
        for (Member member : list) {
            System.out.println(member);
        }
    }

}
