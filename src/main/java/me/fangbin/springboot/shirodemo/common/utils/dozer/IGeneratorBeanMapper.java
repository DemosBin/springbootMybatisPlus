package me.fangbin.springboot.shirodemo.common.utils.dozer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import me.fangbin.springboot.shirodemo.common.bean.PageList;

import java.util.List;
import java.util.Set;

/**
 * @author 90334
 */
public interface IGeneratorBeanMapper {

    /**
     * 单个对象的深度复制及类型转换，vo/domain , po
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return
     */
    <T, S> T convert(S s, Class<T> clz);

    /**
     * 深度复制结果集(PageList为自定义的分页结果集)
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return page
     */
    <T, S> PageList<T> convert(IPage<S> s, Class<T> clz);

    /**
     * list深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return list
     */
    <T, S> List<T> convert(List<S> s, Class<T> clz);

    /**
     * set深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return set
     */
    <T, S> Set<T> convert(Set<S> s, Class<T> clz);

    /**
     * 数组深度复制
     * @param s 数据对象
     * @param clz 复制目标类型
     * @return 数组
     */
    <T, S> T[] convert(S[] s, Class<T> clz);

}
