package me.fangbin.springboot.shirodemo.common.utils.dozer;

import com.baomidou.mybatisplus.core.metadata.IPage;
import me.fangbin.springboot.shirodemo.common.bean.PageList;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Component
@Lazy(true)
public class GeneratorBeanMapperImpl implements IGeneratorBeanMapper {

    @Autowired
    protected Mapper dozerMapper;

    @Override
    public <T, S> T convert(S s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        return this.dozerMapper.map(s, clz);
    }

    @Override
    public <T, S> PageList<T> convert(IPage<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        PageList<T> pageList = new PageList<>();
        List<T> data = new ArrayList<>();
        for (S vs : s.getRecords()) {
            data.add(this.dozerMapper.map(vs, clz));
        }
        pageList.setData(data);
        pageList.setTotal(s.getTotal());
        pageList.setCurrentPage(s.getCurrent());
        pageList.setPageSize(s.getSize());
        return pageList;
    }

    @Override
    public <T, S> List<T> convert(List<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        List<T> list = new ArrayList<T>();
        for (S vs : s) {
            list.add(this.dozerMapper.map(vs, clz));
        }
        return list;
    }

    @Override
    public <T, S> Set<T> convert(Set<S> s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        Set<T> set = new HashSet<T>();
        for (S vs : s) {
            set.add(this.dozerMapper.map(vs, clz));
        }
        return set;
    }

    @Override
    public <T, S> T[] convert(S[] s, Class<T> clz) {
        if (s == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(clz, s.length);
        for (int i = 0; i < s.length; i++) {
            arr[i] = this.dozerMapper.map(s[i], clz);
        }
        return arr;
    }
}

