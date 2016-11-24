package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.Template;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface TemplateService {


    /**
     * find templates.
     *
     * @param template     the template
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the templates
     */
    public PageInfo<Template> findTemplates(Template template, Integer pageNum, Integer pageSize);

    /**
     * find template by template id.
     *
     * @param tplId the template id
     * @return the template by template id
     */
    public Template findTemplateByTplId(Integer tplId);

    /**
     * Delete by template id int.
     *
     * @param tplId the template id
     * @return the int
     */
    @Transactional
    public int deleteByTplId(Integer tplId);

    /**
     * Update by template id int.
     *
     * @param template the template
     * @return the int
     */
    @Transactional
    public int updateByTplId(Template template);

    /**
     * Insert int.
     *
     * @param template the template
     * @return the int
     */
    @Transactional
    public int insert(Template template);
}
