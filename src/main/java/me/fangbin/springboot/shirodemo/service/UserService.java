package me.fangbin.springboot.shirodemo.service;

import me.fangbin.springboot.shirodemo.common.bean.PageList;
import me.fangbin.springboot.shirodemo.dto.UserDTO;
import me.fangbin.springboot.shirodemo.entity.UserEntity;
import me.fangbin.springboot.shirodemo.vo.UserVO;

/**
 * @author 90334
 */
public interface UserService extends BaseService<UserEntity, UserVO, Long> {

    /**
     * 分页查询
     * @param userDTO 查询条件
     * @return 分页查询结果
     */
    PageList<UserVO> getUserByPage(UserDTO userDTO);

    /**
     * 根据账号查询用户
     * @param account 账号（唯一）
     * @return 用户信息
     */
    UserVO getByAccount(String account);

}
