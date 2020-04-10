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
@Table(name = "pe_university")
public class University {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 地区id
     */
    @Column(name = "region_id")
    private Integer regionId;

    /**
     * 院校名称
     */
    private String name;

    /**
     * 院校编码
     */
    private String code;

    /**
     * 校徽
     */
    private String badge;

    /**
     * 院校隶属
     */
    private String subordinate;

    /**
     * 学校类型
     */
    @Column(name = "pro_school_type")
    private String proSchoolType;

    /**
     * 是否为211 0否 1是
     */
    @Column(name = "flag_211")
    private Short flag211;

    /**
     * 是否为985 0否 1是
     */
    @Column(name = "flag_985")
    private Short flag985;

    /**
     * 是否为研究生院 0否1是
     */
    @Column(name = "is_graduate_school")
    private Short isGraduateSchool;

    /**
     * 是否为自划线
     */
    @Column(name = "is_self_scribing")
    private Short isSelfScribing;

    /**
     * 是否为博士点
     */
    @Column(name = "is_doctoral_college")
    private Short isDoctoralCollege;

    /**
     * 状态
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