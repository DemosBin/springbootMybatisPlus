package me.fangbin.springboot.shirodemo.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author BG348516
 * @date 2019/6/14
 */
@Getter
@Setter
public class BaseDTO extends Model implements Serializable {
    private static final long serialVersionUID = 8785592871995449939L;



    @ApiModelProperty(value = "当前第几页")
    private Integer currentPage = 1;

    @ApiModelProperty(value = "每页显示数")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "开始时间 -查询")
    private String beginTime;

    @ApiModelProperty(value = "结束时间 -查询")
    private String endTime;

    @Override
    public String toString() {
        return "BaseDTO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
