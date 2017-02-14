package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.DiagramMapper;
import com.chinamobile.iot.lightapp.mysql.model.Diagram;
import com.chinamobile.iot.lightapp.mysql.model.DiagramExample;
import com.chinamobile.iot.lightapp.mysql.service.DiagramService;
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
public class DiagramServiceImpl implements DiagramService {

    @Autowired
    private DiagramMapper diagramMapper;

    @Override
    public PageInfo<Diagram> findDiagrams(Diagram diagram, Integer pageNum, Integer pageSize) {
        DiagramExample diagramExample = new DiagramExample();
        DiagramExample.Criteria criteria = diagramExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<Diagram> list= diagramMapper.selectByExample(diagramExample);
        return new PageInfo<Diagram>(list);
    }

    @Override
    public Diagram findDiagramByDiagramId(Integer diagramId) {
        return diagramMapper.selectByPrimaryKey(diagramId);
    }

    @Override
    public int deleteByDiagramId(Integer diagramId) {
        return diagramMapper.deleteByPrimaryKey(diagramId);
    }

    @Override
    public int updateByDiagramId(Diagram diagram) {
        return diagramMapper.updateByPrimaryKeySelective(diagram);
    }

    @Override
    public int insert(Diagram diagram) {
        return diagramMapper.insertSelective(diagram);
    }

}
