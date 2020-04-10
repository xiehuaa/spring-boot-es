package com.xh.es.repository;

import com.xh.es.domain.UniversityItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-04-07
 */
public interface UniversityRepository extends ElasticsearchRepository<UniversityItem, Integer> {
    List<UniversityItem> findByNameLikeOrderById(String name);
}
