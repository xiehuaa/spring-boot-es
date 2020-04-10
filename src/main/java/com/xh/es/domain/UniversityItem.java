package com.xh.es.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-04-07
 */
@Setter
@Getter
@Document(indexName = "university", type = "characters")
public class UniversityItem implements Serializable {

    @Id
    private Integer id;

    @Field(type = FieldType.Integer)
    private Integer regionId;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Text)
    private String code;

    private String badge;

    private String subordinate;

    @Field(type = FieldType.Text)
    private String proSchoolType;

    @Field(type = FieldType.Short)
    private Short flag211;

    @Field(type = FieldType.Short)
    private Short flag985;

    @Field(type = FieldType.Short)
    private Short isGraduateSchool;

    @Field(type = FieldType.Short)
    private Short isSelfScribing;

    @Field(type = FieldType.Short)
    private Short isDoctoralCollege;

    @Field(type = FieldType.Short)
    private Short status;

    @Field(type = FieldType.Date)
    private Date createTime;

    @Field(type = FieldType.Date)
    private Date updateTime;
}
