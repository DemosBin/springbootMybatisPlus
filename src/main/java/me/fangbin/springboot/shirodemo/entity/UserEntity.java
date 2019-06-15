package me.fangbin.springboot.shirodemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Getter
@Setter
@TableName("T_USER")
public class UserEntity extends BaseEntity {

    private String account;
    private String name;
    private String password;
    private String email;
}
