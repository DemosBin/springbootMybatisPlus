package me.fangbin.springboot.shirodemo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author BG348516
 * @date 2019/6/14
 */
@Getter
@Setter
public class ResultVO<T> {
    public static final int SUCCESS = 200;
    public static final int ERROR= 500;
    public static final String SUCCESS_MSG = "成功";

    @ApiModelProperty(value = "状态码 200")
    private Integer code;

    @ApiModelProperty(value = "说明信息")
    private String msg;

    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "数据总条数")
    private Integer total;

    public ResultVO() {
        code = SUCCESS;
        msg = SUCCESS_MSG;
    }

    public ResultVO(T data) {
        code = SUCCESS;
        msg = SUCCESS_MSG;
        this.data = data;
    }

    public ResultVO(String msg){
        this.code=ERROR;
        this.msg=msg;
    }

    public ResultVO(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public ResultVO(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public ResultVO(int code,String msg,T data ,Integer total){
        this.code=code;
        this.msg=msg;
        this.data=data;
        this.total=total;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
