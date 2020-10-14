package cn.domain;

/**
 * *    id                   int  auto_increment,
 * *    mid                  int                 --订单预订者
 * *    no                   int		--订单号
 * *    linkman              varchar(30) 		--联系人
 * *    email                varchar(50) 		--email
 * *    phone                varchar(18) 		--电话
 * *    status               varchar	       --订单状态，0：取消、1：确定、2：未生效
 * *    cretime              varchar 		--创建时间
 * *    remark               varchar(100),			--备注
 */

public class Subscription {
    private Integer id;
    private Integer mid;
    private Integer no;
    private String linkman;
    private String email;
    private String phone;
    private String status;
    private String cretime;
    private String remark;

    public Subscription() {
    }

    public Subscription(Integer id, Integer mid, Integer no, String linkman, String email, String phone, String status, String cretime, String remark) {
        this.id = id;
        this.mid = mid;
        this.no = no;
        this.linkman = linkman;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.cretime = cretime;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    //订单状态0取消1确定2未生效
    public String getStatusStr() {
        String str = null;
        switch (status) {
            case "0":
                str = "已取消";
                break;
            case "1":
                str = "确定";
                break;
            case "2":
                str = "未生效";
                break;
        }
        return str;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCretime() {
        return cretime;
    }

    public void setCretime(String cretime) {
        this.cretime = cretime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", mid=" + mid +
                ", no=" + no +
                ", linkman='" + linkman + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", cretime='" + cretime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
