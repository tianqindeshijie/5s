package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.ApplyMapper;
import com.chinamobile.iot.lightapp.mysql.model.Apply;
import com.chinamobile.iot.lightapp.mysql.model.ApplyExample;
import com.chinamobile.iot.lightapp.mysql.service.ApplyService;
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
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public PageInfo<Apply> findApplys(Apply apply, Integer pageNum, Integer pageSize) {
        ApplyExample applyExample = new ApplyExample();
        ApplyExample.Criteria criteria = applyExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<Apply> list= applyMapper.selectByExample(applyExample);
        return new PageInfo<Apply>(list);
    }

    @Override
    public Apply findApplyByApplyId(Integer applyId) {
        return applyMapper.selectByPrimaryKey(applyId);
    }

    @Override
    public int deleteByApplyId(Integer applyId) {
        return applyMapper.deleteByPrimaryKey(applyId);
    }

    @Override
    public int updateByApplyId(Apply apply) {
        return applyMapper.updateByPrimaryKeySelective(apply);
    }

    @Override
    public int insert(Apply apply) {
        return applyMapper.insertSelective(apply);
    }

}
