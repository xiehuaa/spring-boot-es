package com.xh.es.repository;

import com.xh.es.domain.RegionItem;
import com.xh.es.domain.UniversityItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-04-07
 */
public interface RegionRepository extends ElasticsearchRepository<RegionItem, Integer> {

}
