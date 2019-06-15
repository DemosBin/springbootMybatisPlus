package me.fangbin.springboot.shirodemo.common.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Getter
@Setter
public class PageList<T> {
    /**
     * 每页的列表
     */
    private List<T> data;

    /**
     * 总记录数
     */
    private long total = 0;

    /**
     * 当前页码
     */
    private long currentPage = 1;

    /**
     * 每页记录数 page size
     */
    private long pageSize = 10;
}
