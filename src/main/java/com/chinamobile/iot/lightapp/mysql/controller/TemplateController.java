package com.chinamobile.iot.lightapp.mysql.controller;

import com.chinamobile.iot.lightapp.mysql.Request.AddTemplateRequest;
import com.chinamobile.iot.lightapp.mysql.Request.UpdateTemplateRequest;
import com.chinamobile.iot.lightapp.mysql.model.Template;
import com.chinamobile.iot.lightapp.mysql.service.TemplateService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The devices controller.
 *
 * @author sxt
 * @since 2016.10.25
 */
@RestController
@RequestMapping("/mysql")
@Api("模板管理")
public class TemplateController {
    private static Logger logger = LoggerFactory.getLogger(TemplateController.class);
    @Autowired
    private TemplateService templateService;

    /**
     * 根据指定tplId查询模板信息
     *
     * @param tplId the tpl id
     * @return the template by tpl id
     */
    @ApiOperation(value = "查询模板信息", notes = "根据tplId查询模板信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "commandId", value = "命令ID(commandId)", required = true, dataType = "Integer")})
    @RequestMapping(path = "/templates/{tplId}", method = RequestMethod.GET)
    public Template getTemplateByTplId(@PathVariable("tplId") Integer tplId) {
        return templateService.findTemplateByTplId(tplId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param tplName    the tpl name
     * @param tplContent the tpl content
     * @param tplType    the tpl type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the templates
     */
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query",name = "tplName", value = "模板名称", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "tplContent", value = "模板内容", required = false, dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "tplType", value = "模板类型(0短信模板,1邮件模板)", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageNum", value = "当前页", required = false, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query",name = "pageSize", value = "每页数量", required = false, dataType = "Integer")})
    @RequestMapping(value = "/templates", method = RequestMethod.GET)
    public PageInfo<Template> getTemplates(@RequestParam(value = "tplName", required = false) String tplName,
                                           @RequestParam(value = "tplContent", required = false) String tplContent,
                                           @RequestParam(value = "tplType", required = false) Integer tplType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Template template = new Template();
        template.setTplName(tplName);
        template.setTplContent(tplContent);
        template.setTplType(tplType);
        return templateService.findTemplates(template, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param addTemplateRequest the add template request
     * @return the integer
     */
    @ApiOperation(value = "新增模板信息", notes = "新增模板信息")
    @RequestMapping(value = "/templates", method = RequestMethod.POST)
    public Integer addTemplate(@RequestBody AddTemplateRequest addTemplateRequest) {
        Template template = new Template();
        //拷贝属性
        BeanUtils.copyProperties(addTemplateRequest, template);
        return templateService.insert(template);
    }

    /**
     * 更新模板信息.
     *
     * @param updateTemplateRequest the update template request
     * @return the integer
     */
    @RequestMapping(value = "/templates", method = RequestMethod.PUT)
    public Integer updateTemplate(@RequestBody UpdateTemplateRequest updateTemplateRequest) {
        Template template = new Template();
        //拷贝属性
        BeanUtils.copyProperties(updateTemplateRequest, template);
        return templateService.updateByTplId(template);
    }

    /**
     * 根据指定的tplId删除模板信息
     *
     * @param tplId the tpl id
     * @return the integer
     */
    @ApiOperation(value = "删除模板信息", notes = "根据tplId删除模板信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "commandId", value = "命令ID(commandId)", required = true, dataType = "Integer")})
    @RequestMapping(value = "/templates/{tplId}", method = RequestMethod.DELETE)
    public Integer deleteTemplate(@PathVariable("tplId") Integer tplId) {
        return templateService.deleteByTplId(tplId);
    }

}
