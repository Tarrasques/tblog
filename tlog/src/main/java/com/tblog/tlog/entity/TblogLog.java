package com.tblog.tlog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (TblogLog)实体类
 *
 * @author makejava
 * @since 2022-07-28 15:04:38
 */
@Data
public class TblogLog implements Serializable {
    private static final long serialVersionUID = 857556274666551295L;

    private String id;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户操作者
     */
    private  String userName;

    private String start;
    private String end;

}

