package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.RegionMapper;
import com.chinamobile.iot.lightapp.mysql.dao.RegionMapperExt;
import com.chinamobile.iot.lightapp.mysql.dao.UserWorkcycleMapper;
import com.chinamobile.iot.lightapp.mysql.dto.RegionDTO;
import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.model.RegionExample;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycle;
import com.chinamobile.iot.lightapp.mysql.model.UserWorkcycleExample;
import com.chinamobile.iot.lightapp.mysql.service.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private RegionMapperExt regionMapperExt;
    @Autowired
    private UserWorkcycleMapper userWorkcycleMapper;

    @Override
    public PageInfo<RegionDTO> findRegions(Region region, Integer userId, Integer pageNum, Integer pageSize) {
        //查询用户所有的工作圈
        UserWorkcycleExample userWorkcycleExample = new UserWorkcycleExample();
        UserWorkcycleExample.Criteria criteria = userWorkcycleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<UserWorkcycle> list = userWorkcycleMapper.selectByExample(userWorkcycleExample);
        List<Integer> workCycleList = new ArrayList<Integer>();
        if (list != null && list.size() > 0) {
            for (UserWorkcycle temp : list) {
                workCycleList.add(temp.getWorkCycleId());
            }
        }

        //查询Region信息
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria criteria1 = regionExample.createCriteria();
        String regionName = region.getRegionName();
        if (regionName != null && regionName.trim().length() > 0) {
            criteria1.andRegionNameLike(regionName);
        }
        criteria1.andCycleIdIn(workCycleList);
        PageHelper.startPage(pageNum, pageSize, true, false);
        List<RegionDTO> regionList = regionMapperExt.selectByExample(regionExample);
        return new PageInfo<RegionDTO>(regionList);
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
