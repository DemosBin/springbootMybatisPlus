package me.fangbin.springboot.shirodemo.service;

import java.util.List;

/**
 * @author 90334
 */
public interface BaseService<Entity, VO, PK> {
    /**
     * 增加
     * @param vo vo
     */
    void save(VO vo);

    /**
     * 修改
     * @param vo vo
     */
    void update(VO vo);

    /**
     * 通过主键删除
     * @param pk pk
     */
    void deleteByPK(PK pk);
    /**
     * 删除
     * @param vo
   */
    void delete(VO vo);

    /**
     * 通过主键查询
     * @param pk 主键
     * @return 查询结果
     */
    VO get(PK pk);

    /**
     * 查询全部
     * @return
     */
    List<VO> findAll();
}