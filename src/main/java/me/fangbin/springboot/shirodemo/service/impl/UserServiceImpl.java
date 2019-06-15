package me.fangbin.springboot.shirodemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import me.fangbin.springboot.shirodemo.common.bean.PageList;
import me.fangbin.springboot.shirodemo.common.utils.dozer.IGeneratorBeanMapper;
import me.fangbin.springboot.shirodemo.dao.UserDao;
import me.fangbin.springboot.shirodemo.dto.UserDTO;
import me.fangbin.springboot.shirodemo.entity.UserEntity;
import me.fangbin.springboot.shirodemo.service.UserService;
import me.fangbin.springboot.shirodemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserEntity, UserVO, Long> implements UserService {

    private final UserDao userDao;
    private IGeneratorBeanMapper beanMapper;

    @Autowired
    public UserServiceImpl(UserDao userDao, IGeneratorBeanMapper beanMapper) {
        this.userDao = userDao;
        this.beanMapper = beanMapper;
    }

    @Override
    public void afterConstruct() {}

    @Override
    public PageList<UserVO> getUserByPage(UserDTO dto) {
        Page<UserEntity> page = new Page<>(dto.getCurrentPage(), dto.getPageSize());
        Wrapper<UserEntity> userDTOWrapper = new QueryWrapper<>(beanMapper.convert(dto, UserEntity.class));
        return beanMapper.convert(userDao.selectPage(page, userDTOWrapper), UserVO.class);
    }

    @Override
    public UserVO getByAccount(String account) {
        return beanMapper.convert(userDao.getByAccount(account), UserVO.class);
    }
}
