package com.jia.demo.service;

import com.jia.demo.dao.AreaDao;
import com.jia.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void queryAreaList() {
        List<Area> areaList = areaService.queryAreaList();
        assertEquals(2, areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaService.queryAreaById(1);
        assertEquals("广州", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("惠州");
        area.setPriority(1);
        boolean isCreated = areaService.insertArea(area);
        assertEquals(true, isCreated);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(6);
        area.setAreaName("北京");
        area.setLastEditTime(new Date());
        boolean isUpdated = areaService.updateArea(area);
        assertEquals(isUpdated, true);
    }

    @Test
    public void deleteArea() {
        boolean isDeleted = areaService.deleteArea(6);
        assertEquals(isDeleted, true);
    }
}
