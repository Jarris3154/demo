package com.jia.demo.dao;

import com.jia.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryAreaList() {
        List<Area> areaList = areaDao.queryAreaList();
        assertEquals(2, areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("广州", area.getAreaName());
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("惠州");
        area.setPriority(1);
        int effectedRow = areaDao.insertArea(area);
        assertEquals(1, effectedRow);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(3);
        area.setAreaName("北京");
        area.setLastEditTime(new Date());
        int effectedRow = areaDao.updateArea(area);
        assertEquals(1, effectedRow);
    }

    @Test
    public void deleteArea() {
        int effectedRow = areaDao.deleteArea(3);
        assertEquals(1, effectedRow);
    }
}