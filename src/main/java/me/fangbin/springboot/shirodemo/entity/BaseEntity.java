package me.fangbin.springboot.shirodemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Getter
@Setter
public class BaseEntity extends Model implements Serializable {
    private static final long serialVersionUID = -4029677472353606772L;
    @TableId("id")
    private Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
