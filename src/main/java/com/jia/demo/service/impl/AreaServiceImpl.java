package com.jia.demo.service.impl;

import com.jia.demo.dao.AreaDao;
import com.jia.demo.entity.Area;
import com.jia.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryAreaList() {
        return areaDao.queryAreaList();
    }

    @Override
    public Area queryAreaById(int areaId) {
        //int a = 1/0;
        return areaDao.queryAreaById(areaId);
    }

    //添加业务
    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedRow = areaDao.insertArea(area);
                if (effectedRow > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败: " + e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }

    }

    @Override
    public boolean updateArea(Area area) {
        //空值判断， 主要是areaId不能为空
        if(area.getAreaId() !=null && area.getAreaId() > 0){
            //设置默认值
            area.setLastEditTime(new Date());
            try{
                //更新区域信息
                int effectedRow = areaDao.updateArea(area);
                if(effectedRow > 0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败： "+ e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空。");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                //删除区域信息
                int effectedRow = areaDao.deleteArea(areaId);
                if(effectedRow > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败：" + e.getMessage());
            }
        }
        throw new RuntimeException("区域Id不能为空");
    }
}
