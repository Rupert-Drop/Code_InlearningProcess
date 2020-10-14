package cn.domain;

public class Room {
    private Integer id;
    private Integer cid;
    private String no;
    private Integer status;

    public Room() {
    }

    public Room(Integer id, Integer cid, String no, Integer status) {
        this.id = id;
        this.cid = cid;
        this.no = no;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
