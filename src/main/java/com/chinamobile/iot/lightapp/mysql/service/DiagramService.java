package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.Diagram;
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
public interface DiagramService {


    /**
     * find diagrams.
     *
     * @param diagram     the diagram
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the diagrams
     */
    public PageInfo<Diagram> findDiagrams(Diagram diagram, Integer pageNum, Integer pageSize);

    /**
     * find diagram by diagram id.
     *
     * @param diagramId the diagram id
     * @return the diagram by diagram id
     */
    public Diagram findDiagramByDiagramId(Integer diagramId);

    /**
     * Delete by diagram id int.
     *
     * @param diagramId the diagram id
     * @return the int
     */
    @Transactional
    public int deleteByDiagramId(Integer diagramId);

    /**
     * Update by diagram id int.
     *
     * @param diagram the diagram
     * @return the int
     */
    @Transactional
    public int updateByDiagramId(Diagram diagram);

    /**
     * Insert int.
     *
     * @param diagram the diagram
     * @return the int
     */
    @Transactional
    public int insert(Diagram diagram);
}
