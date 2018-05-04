package com.jia.demo.web;


import com.jia.demo.entity.Area;
import com.jia.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    private Map<String, Object>getAreaList(){
        Map<String, Object> modelMap = new HashMap<String, Object>();

        List<Area> areaList = areaService.queryAreaList();
        modelMap.put("areaList", areaList);
        return modelMap;
    }

    @GetMapping("/{id}")
    private Map<String, Object>getAreaById(@PathVariable(value = "id") Integer areaId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    @PostMapping
    private Map<String, Object>insertArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isCreated = areaService.insertArea(area);
        modelMap.put("success", isCreated);
        return modelMap;
    }

    @PutMapping("/{id}")
    private Map<String, Object>updateArea(@PathVariable(value="id")Integer areaId, @RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        area.setAreaId(areaId);
        boolean isUpdated = areaService.updateArea(area);
        modelMap.put("success", isUpdated);
        return modelMap;
    }

    @DeleteMapping(value = "/{id}")
    private Map<String, Object>deleteArea(@PathVariable("id") Integer areaId){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean idDeleted = areaService.deleteArea(areaId);
        modelMap.put("success", idDeleted);
        return modelMap;
    }

}
