package me.fangbin.springboot.shirodemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import me.fangbin.springboot.shirodemo.entity.UserEntity;

/**
 * @author 90334
 */
public interface UserDao extends BaseMapper<UserEntity> {
    UserEntity getByAccount(String account);
}
