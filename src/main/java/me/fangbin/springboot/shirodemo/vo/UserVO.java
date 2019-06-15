package me.fangbin.springboot.shirodemo.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Getter
@Setter
public class UserVO implements Serializable {
    private static final long serialVersionUID = 9063232738999763142L;

    private Long id;
    private String account;
    private String name;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
