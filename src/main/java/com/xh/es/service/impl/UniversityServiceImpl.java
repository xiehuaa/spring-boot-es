package com.xh.es.service.impl;

import com.xh.es.domain.University;
import com.xh.es.domain.UniversityItem;
import com.xh.es.mapper.UniversityMapper;
import com.xh.es.repository.UniversityRepository;
import com.xh.es.service.UniversityService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-04-07
 */
@Slf4j
@Service
public class UniversityServiceImpl implements UniversityService {
    @Resource
    private UniversityMapper universityMapper;

    @Resource
    private UniversityRepository universityRepository;

    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public void initEsData() {
        elasticsearchRestTemplate.deleteIndex(UniversityItem.class);
        elasticsearchRestTemplate.createIndex(UniversityItem.class);

        List<University> universities = universityMapper.selectAll();
        List<UniversityItem> universityItemList = new ArrayList<>();
        for (University university : universities) {
            UniversityItem universityItem = new UniversityItem();
            BeanUtils.copyProperties(university, universityItem);

            universityItemList.add(universityItem);
        }
        universityRepository.saveAll(universityItemList);
    }

    @Override
    public List<University> listByName(String name) {
        List<UniversityItem> universityItemList = universityRepository.findByNameLikeOrderById(name);
        List<University> universities = new ArrayList<>();
        for (UniversityItem universityItem : universityItemList) {
            University university = new University();
            BeanUtils.copyProperties(universityItem, university);

            universities.add(university);
        }
        return universities;
    }

    @Override
    public Map<String, Object> pageList(Integer pageNum, Integer pageSize, String name) {
        NativeSearchQueryBuilder searchQueryBuilder = new NativeSearchQueryBuilder();
        if (!StringUtils.isEmpty(name)) {
            searchQueryBuilder.withQuery(QueryBuilders.matchQuery("name", name));
            searchQueryBuilder.withSort(SortBuilders.scoreSort());
        } else {
            searchQueryBuilder.withSort(SortBuilders.fieldSort("id"));
        }

        searchQueryBuilder.withPageable(PageRequest.of(pageNum - 1, pageSize));

        Page<UniversityItem> universityItemPage = universityRepository.search(searchQueryBuilder.build());
        List<UniversityItem> universityItemList = universityItemPage.getContent();
        List<University> universities = new ArrayList<>();
        for (UniversityItem universityItem : universityItemList) {
            University university = new University();
            BeanUtils.copyProperties(universityItem, university);

            universities.add(university);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("total", universityItemPage.getTotalElements());
        result.put("pages", universityItemPage.getTotalPages());
        result.put("data", universities);
        result.put("pageNum", pageNum);
        result.put("pageSize", pageSize);
        return result;
    }
}
