package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Diagram;
import com.chinamobile.iot.lightapp.mysql.service.DiagramService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController

@Api("模板管理")
public class DiagramController {
    private static Logger logger = LoggerFactory.getLogger(DiagramController.class);
    @Autowired
    private DiagramService diagramService;

    /**
     * 根据指定diagramId查询模板信息
     *
     * @param diagramId the diagram id
     * @return the diagram by diagram id
     */
    @RequestMapping(path = "/diagrams/{diagramId}", method = RequestMethod.GET)
    public Diagram getDiagramByDiagramId(@PathVariable("diagramId") Integer diagramId) {
        return diagramService.findDiagramByDiagramId(diagramId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param diagramName    the diagram name
     * @param diagramContent the diagram content
     * @param diagramType    the diagram type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the diagrams
     */

    @RequestMapping(value = "/diagrams", method = RequestMethod.GET)
    public PageInfo<Diagram> getDiagrams(@RequestParam(value = "diagramName", required = false) String diagramName,
                                           @RequestParam(value = "diagramContent", required = false) String diagramContent,
                                           @RequestParam(value = "diagramType", required = false) Integer diagramType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Diagram diagram = new Diagram();

        return diagramService.findDiagrams(diagram, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param diagram the add diagram request
     * @return the integer
     */
    @RequestMapping(value = "/diagrams", method = RequestMethod.POST)
    public Integer addDiagram(@RequestBody Diagram diagram) {
        return diagramService.insert(diagram);
    }

    /**
     * 更新模板信息.
     *
     * @param diagram the update diagram request
     * @return the integer
     */
    @RequestMapping(value = "/diagrams", method = RequestMethod.PUT)
    public Integer updateDiagram(@RequestBody Diagram diagram) {
        return diagramService.updateByDiagramId(diagram);
    }

    /**
     * 根据指定的diagramId删除模板信息
     *
     * @param diagramId the diagram id
     * @return the integer
     */
    @RequestMapping(value = "/diagrams/{diagramId}", method = RequestMethod.DELETE)
    public Integer deleteDiagram(@PathVariable("diagramId") Integer diagramId) {
        return diagramService.deleteByDiagramId(diagramId);
    }

}
