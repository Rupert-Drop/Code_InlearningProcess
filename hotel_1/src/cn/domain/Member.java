package cn.domain;

/**
 * *    id                   int not null auto_increment,
 * *    username             varchar(20) not null,
 * *    password                  varchar(15) not null,
 * *    name                 varchar(30),
 * *    email                varchar(50),
 * *    phone                varchar(18),
 * *    regtime              varchar
 */
public class Member {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String regtime;

    public Member() {
    }

    public Member(Integer id, String username, String password, String name, String email, String phone, String regtime) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.regtime = regtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }
}
