package cn.domain;

public class Subscription_dtl {
    /*
    id                   int
   rid                  int,			--房间号码
   sid                  int,			--订单号
   sdate                string		--开始时间
   edate                string	--结束时间
   residetype           string	        --预定方式
   price                float ,		--价格*/
    private Integer id;
    private Integer rid;
    private Integer sid;
    private String sdate;
    private String edate;
    private String residetype;
    private String price;

    public Subscription_dtl() {
    }

    public Subscription_dtl(Integer id, Integer rid, Integer sid, String sdate, String edate, String residetype, String price) {
        this.id = id;
        this.rid = rid;
        this.sid = sid;
        this.sdate = sdate;
        this.edate = edate;
        this.residetype = residetype;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSdate() {
        return sdate;
    }

    public void setSdate(String sdate) {
        this.sdate = sdate;
    }

    public String getEdate() {
        return edate;
    }

    public void setEdate(String edate) {
        this.edate = edate;
    }

    public String getResidetype() {
        return residetype;
    }

    public void setResidetype(String residetype) {
        this.residetype = residetype;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
