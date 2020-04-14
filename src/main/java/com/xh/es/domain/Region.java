package com.xh.es.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "pe_region")
public class Region {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 拼音
     */
    @Column(name = "pinyin_name")
    private String pinyinName;

    /**
     * 状态 1正常
     */
    private Short status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;
}