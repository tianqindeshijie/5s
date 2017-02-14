package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.RegionMapper;
import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.model.RegionExample;
import com.chinamobile.iot.lightapp.mysql.service.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public PageInfo<Region> findRegions(Region region, Integer pageNum, Integer pageSize) {
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria criteria = regionExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<Region> list= regionMapper.selectByExample(regionExample);
        return new PageInfo<Region>(list);
    }

    @Override
    public Region findRegionByRegionId(Integer regionId) {
        return regionMapper.selectByPrimaryKey(regionId);
    }

    @Override
    public int deleteByRegionId(Integer regionId) {
        return regionMapper.deleteByPrimaryKey(regionId);
    }

    @Override
    public int updateByRegionId(Region region) {
        return regionMapper.updateByPrimaryKeySelective(region);
    }

    @Override
    public int insert(Region region) {
        return regionMapper.insertSelective(region);
    }

}
