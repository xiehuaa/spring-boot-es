package com.xh.es.controller;

import com.xh.es.domain.University;
import com.xh.es.service.UniversityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Create By IntelliJ IDEA
 *
 * @author XieHua
 * @date 2020-04-07
 */
@RestController
public class UniversityController {
    @Resource
    private UniversityService universityService;

    @GetMapping(value = "/university/es/init")
    public String initEsData() {
        universityService.initEsData();
        return "success";
    }

    @GetMapping(value = "/universities/name/{name}")
    public List<University> listByName(@PathVariable String name) {
        return universityService.listByName(name);
    }

    @GetMapping(value = "/universities/page")
    public Map<String, Object> pageList(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                                        @RequestParam(required = false) String name) {
        return universityService.pageList(pageNum, pageSize, name);
    }
}
