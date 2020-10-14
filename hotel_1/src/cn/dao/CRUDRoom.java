package cn.dao;

import cn.domain.Room;
import cn.util.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CRUDRoom {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSourse());

    public static void main(String[] args) {
        CRUDRoom crudRoom = new CRUDRoom();
        crudRoom.selectRoom();
    }

    public List<Room> selectRoom() {
        //cid:确定房间类型  status:确定房间状态
        String sql = "select * from room where status=1";
        List<Room> list = template.query(sql, new BeanPropertyRowMapper<Room>(Room.class));
        return list;
    }

}
