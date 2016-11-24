package com.chinamobile.iot.lightapp.mysql.service.Impl;

import com.chinamobile.iot.lightapp.mysql.dao.TemplateMapper;
import com.chinamobile.iot.lightapp.mysql.model.Template;
import com.chinamobile.iot.lightapp.mysql.model.TemplateExample;
import com.chinamobile.iot.lightapp.mysql.service.TemplateService;
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
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateMapper templateMapper;

    @Override
    public PageInfo<Template> findTemplates(Template template, Integer pageNum, Integer pageSize) {
        TemplateExample templateExample = new TemplateExample();
        TemplateExample.Criteria criteria = templateExample.createCriteria();

        String tplName = template.getTplName();
        if(tplName != null && tplName.trim().length() > 0) {
            criteria.andTplNameEqualTo(tplName);
        }
        String tplContent = template.getTplContent();
        if(tplContent != null && tplContent.trim().length() > 0) {
            criteria.andTplContentEqualTo(tplContent);
        }
        Integer tplType = template.getTplType();
        if(tplType != null) {
            criteria.andTplTypeEqualTo(tplType);
        }
        PageHelper.startPage(pageNum, pageSize,true,false);
        List<Template> list= templateMapper.selectByExample(templateExample);
        return new PageInfo<Template>(list);
    }

    @Override
    public Template findTemplateByTplId(Integer tplId) {
        return templateMapper.selectByPrimaryKey(tplId);
    }

    @Override
    public int deleteByTplId(Integer tplId) {
        return templateMapper.deleteByPrimaryKey(tplId);
    }

    @Override
    public int updateByTplId(Template template) {
        return templateMapper.updateByPrimaryKeySelective(template);
    }

    @Override
    public int insert(Template template) {
        return templateMapper.insertSelective(template);
    }

}
