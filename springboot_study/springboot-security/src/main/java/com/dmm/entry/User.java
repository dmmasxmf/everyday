package com.dmm.entry;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/3 15:29
 * @motto The more learn, the more found his ignorance.
 */
@Entity
@Table
public class User implements Serializable {

    //https://www.cnblogs.com/itiande/p/9139161.html
    // 这是因为在实体的getID方法上没有加上此@Id注解，但是检查了一次确实加上了，最后的解决办法如下：
    //import org.springframework.data.annotation.Id;
    // import javax.persistence.Id;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

