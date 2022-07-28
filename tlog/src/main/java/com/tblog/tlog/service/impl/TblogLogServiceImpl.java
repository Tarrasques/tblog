package com.tblog.tlog.service.impl;

import com.tblog.tlog.mapper.TblogLogMapper;
import com.tblog.tlog.service.TblogLogService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (TblogLog)表服务实现类
 *
 * @author makejava
 * @since 2022-07-28 15:04:38
 */
@Service("tblogLogService")
@Log4j2
public class TblogLogServiceImpl implements TblogLogService {

    @Autowired
    private TblogLogMapper tblogLogMapper;

//    /**
//     * 通过ID查询单条数据
//     *
//     * @param id 主键
//     * @return 实例对象
//     */
//    @Override
//    public TblogLog queryById(String id) {
//        return tblogLogMapper.queryById(id);
//    }
//
//    /**
//     * 分页查询
//     *
//     * @param tblogLog    筛选条件
//     * @param pageRequest 分页对象
//     * @return 查询结果
//     */
//    @Override
//    public Page<TblogLog> queryByPage(TblogLog tblogLog, PageRequest pageRequest) {
//        long total = tblogLogMapper.count(tblogLog);
//        return new PageImpl<>(tblogLogMapper.queryAllByLimit(tblogLog, pageRequest), pageRequest, total);
//    }
//
//    /**
//     * 新增数据
//     *
//     * @param tblogLog 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public TblogLog insert(TblogLog tblogLog) {
//        tblogLogMapper.insert(tblogLog);
//        return tblogLog;
//    }
//
//    /**
//     * 修改数据
//     *
//     * @param tblogLog 实例对象
//     * @return 实例对象
//     */
//    @Override
//    public TblogLog update(TblogLog tblogLog) {
//        tblogLogMapper.update(tblogLog);
//        return queryById(tblogLog.getId());
//    }
//
//    /**
//     * 通过主键删除数据
//     *
//     * @param id 主键
//     * @return 是否成功
//     */
//    @Override
//    public boolean deleteById(String id) {
//        return tblogLogMapper.deleteById(id) > 0;
//    }
}
