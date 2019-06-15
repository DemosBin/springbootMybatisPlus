package me.fangbin.springboot.shirodemo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Getter
@Setter
public class UserDTO extends BaseDTO {
    private static final long serialVersionUID = -8146524701188145118L;
    private Long id;
    private String account;
    private String name;
    private String password;
    private String email;

    @Override
    public String toString() {
        return "UserDTO{" +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
