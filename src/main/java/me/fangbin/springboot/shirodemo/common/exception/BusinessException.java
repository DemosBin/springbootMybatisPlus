package me.fangbin.springboot.shirodemo.common.exception;

/**
 * @author BG348516
 * @date 2019/6/14
 */
public class BusinessException extends  RuntimeException {
    public BusinessException(String msg){
        super(msg);
    }
}
