package com.xh.es.service;

import com.xh.es.domain.University;

import java.util.List;
import java.util.Map;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-04-07
 */
public interface UniversityService {
    void initEsData();

    List<University> listByName(String name);

    Map<String, Object> pageList(Integer pageNum, Integer pageSize, String name);
}
