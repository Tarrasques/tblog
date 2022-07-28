package com.tblog.tlog.mapper;

import com.tblog.tlog.entity.TblogLog;
import org.springframework.stereotype.Repository;

@Repository
public interface TblogLogMapper {

    int insert(TblogLog log);

}
