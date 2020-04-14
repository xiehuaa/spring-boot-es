package com.xh.es.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Getter
@Setter
@Document(indexName = "region", type = "region")
public class RegionItem {

    @Id
    private Integer id;

    /**
     * 地区名称
     */
    @Field(type = FieldType.Keyword)
    private String name;

    /**
     * 拼音
     */
    @Field(type = FieldType.Keyword)
    private String pinyinName;

    /**
     * 状态 1正常
     */
    @Field(type = FieldType.Keyword)
    private Short status;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Long)
    private Date createTime;

    /**
     * 更新时间
     */
    @Field(type = FieldType.Long)
    private Date updateTime;
}