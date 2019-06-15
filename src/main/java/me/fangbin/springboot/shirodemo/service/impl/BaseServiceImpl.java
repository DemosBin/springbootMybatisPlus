package me.fangbin.springboot.shirodemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import me.fangbin.springboot.shirodemo.common.utils.dozer.IGeneratorBeanMapper;
import me.fangbin.springboot.shirodemo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author BG348516
 * @date 2019/6/15
 */
public abstract class BaseServiceImpl<Entity extends Model, VO, PK extends Serializable> implements BaseService<Entity, VO, PK> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected BaseMapper<Entity> baseDao;
    @SuppressWarnings({ "rawtypes" })
    private Class<Entity> entityClass;
    @SuppressWarnings({ "rawtypes" })
    private Class<VO> entityVOClass;

    private IGeneratorBeanMapper beanMapper;

    /**
     * 请在这里给baseDao，modelClass和modelVOClass赋值
     * eg.
     *      UserServiceImpl.java:
     *              @PostConstruct
     *              public void afterConstruct(){
     *                  super.setBaseDao(userDao);
     *                  super.setModelClass(user.class);
     *                  super.setModelVOClass(userVO.class);
     *              }
     */
    @PostConstruct
    abstract public void afterConstruct();

    @SuppressWarnings({ "rawtypes" })
    public Class getEntityClass() {
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        //返回表示此类型实际类型参数的 Type 对象的数组()，想要获取第一个泛型(Entity)的Class，所以索引写0
        return (Class)type.getActualTypeArguments()[0];
    }

    @SuppressWarnings({ "rawtypes" })
    private Class getEntityVOClass() {
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        //返回表示此类型实际类型参数的 Type 对象的数组()，想要获取第二个泛型(VO)的Class，所以索引写1
        return (Class)type.getActualTypeArguments()[1];
    }

    @Autowired
    public void setOrikaBeanMapper(IGeneratorBeanMapper beanMapper) {
        this.beanMapper = beanMapper;
    }

    @Override
    public void save(VO vo) {
        Entity entity = (Entity) beanMapper.convert(vo, getEntityClass());
        baseDao.insert(entity);
    }

    @Override
    public void update(VO vo) {
        Entity entity = (Entity) beanMapper.convert(vo, getEntityClass());
        baseDao.updateById(entity);
    }

    @Override
    public void deleteByPK(PK id) {
        baseDao.deleteById(id);
    }

    @Override
    public void delete(VO vo) {
        Wrapper<Entity> userDTOWrapper = new QueryWrapper<>((Entity) beanMapper.convert(vo, getEntityClass()));
        baseDao.delete(userDTOWrapper);
    }

    @Override
    public VO get(PK id) {
        return (VO) beanMapper.convert(baseDao.selectById(id), getEntityVOClass());
    }

    @Override
    public List<VO> findAll() {
        return  (List<VO>) beanMapper.convert(baseDao.selectList(null), getEntityVOClass());
    }
}
