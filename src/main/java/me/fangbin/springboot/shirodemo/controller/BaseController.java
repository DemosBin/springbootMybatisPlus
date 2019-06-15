package me.fangbin.springboot.shirodemo.controller;

import lombok.extern.slf4j.Slf4j;
import me.fangbin.springboot.shirodemo.common.exception.BusinessException;
import me.fangbin.springboot.shirodemo.vo.ResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Slf4j
public class BaseController {
    /**
     * 抛出自定义BusinessException异常
     */
    @ExceptionHandler({BusinessException.class})
    @ResponseBody
    public ResultVO business(BusinessException ex) {
        log.info(ex.toString());
        return new ResultVO(ResultVO.ERROR,ex.getMessage());
    }

    protected void check(String code ,Object obj){
        String n = "null";
        if (obj==null|| n.equals(obj.toString().trim()) ||obj.toString().trim().length()==0) {
            throw new BusinessException("参数【{" + code + "}】不能为空");
        }
    }
}
