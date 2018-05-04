package com.jia.demo.service;

import com.jia.demo.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     *  列出区域列表
     * @return areaList
     */
    List<Area> queryAreaList();

    /**
     * 根据id查出具体区域
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     * @param area
     * @return areaId
     */
    boolean insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return areaId
     */
    boolean updateArea(Area area);

    /**
     * 根据areaId删除区域
     * @param areaId
     * @return areaId
     */
    boolean deleteArea(int areaId);


}
