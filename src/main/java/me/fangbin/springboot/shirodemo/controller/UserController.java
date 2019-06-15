package me.fangbin.springboot.shirodemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.fangbin.springboot.shirodemo.common.bean.PageList;
import me.fangbin.springboot.shirodemo.common.exception.BusinessException;
import me.fangbin.springboot.shirodemo.common.utils.dozer.IGeneratorBeanMapper;
import me.fangbin.springboot.shirodemo.dto.UserDTO;
import me.fangbin.springboot.shirodemo.entity.UserEntity;
import me.fangbin.springboot.shirodemo.service.UserService;
import me.fangbin.springboot.shirodemo.vo.ResultVO;
import me.fangbin.springboot.shirodemo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@RestController
@RequestMapping("/")
@Api(description = "用户接口")
@Slf4j
public class UserController extends BaseController {

    private final UserService userService;
    private final IGeneratorBeanMapper beanMapper;

    @Autowired
    public UserController(UserService userService, IGeneratorBeanMapper beanMapper) {
        this.userService = userService;
        this.beanMapper = beanMapper;
    }

    @ApiOperation(value = "登录", response = ResultVO.class)
    @PostMapping("login")
    public ResultVO login(@RequestBody UserDTO user) {
        UserVO userVO = userService.getByAccount(user.getAccount());
        if (null == userVO) {
            throw new BusinessException("账号不存在");
        }
        if (!user.getPassword().equals(userVO.getPassword())) {
            throw new BusinessException("密码不正确");
        }
        return new ResultVO<>();
    }

    @ApiOperation(value = "添加用户", response = ResultVO.class)
    @PostMapping("user/add")
    public ResultVO addUser(@RequestBody UserVO vo) {
        userService.save(vo);
        return new ResultVO<>();
    }

    @ApiOperation(value = "修改用户", response = ResultVO.class)
    @PutMapping("user/modify")
    public ResultVO modifyUser(@RequestBody UserVO vo) {
        userService.update(vo);
        return new ResultVO<>();
    }

    @ApiOperation(value = "查询单个用户详情", response = ResultVO.class)
    @PostMapping("user/get")
    public ResultVO<UserVO> queryUserById(@RequestParam(value = "id") Long id) {
        UserVO user = userService.get(id);
        return new ResultVO<>(user);
    }

    @ApiOperation(value = "查询全部用户", response = ResultVO.class)
    @PostMapping("user/query")
    public ResultVO<List<UserVO>> queryAllUser() {
        List<UserVO> allUsers = userService.findAll();
        return new ResultVO<>(ResultVO.SUCCESS, ResultVO.SUCCESS_MSG, allUsers);
    }

    @ApiOperation(value = "分页查询全部用户", response = ResultVO.class)
    @PostMapping("user/querypage")
    public ResultVO<PageList<UserVO>> queryAllUser(@RequestBody UserDTO dto) {
        PageList<UserVO> userByPage = userService.getUserByPage(dto);
        return new ResultVO<>(userByPage);
    }

    @ApiOperation(value = "删除用户", response = ResultVO.class)
    @PutMapping("user/delete")
    public ResultVO deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteByPK(id);
        return new ResultVO<>();
    }
}
