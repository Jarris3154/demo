package com.jia.demo.web;

import com.jia.demo.entity.Area;
import com.jia.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/areas")
public class AreaControllerTest {

    @Autowired
    private AreaService areaService;

    @GetMapping
    private Map<String, Object>listArea(){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        List<Area> areaList = areaService.queryAreaList();
        modelMap.put("areaList", areaList);
        return modelMap;
    }

}
