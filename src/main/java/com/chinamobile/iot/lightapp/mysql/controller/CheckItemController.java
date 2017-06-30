package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.UpdateCheckItemDTO;
import com.chinamobile.iot.lightapp.mysql.model.CheckItem;
import com.chinamobile.iot.lightapp.mysql.request.AddCheckItemRequest;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

@Api("检查小项管理")
public class CheckItemController {
    private static Logger logger = LoggerFactory.getLogger(CheckItemController.class);
    @Autowired
    private CheckItemService checkItemService;

    /**
     * 根据指定checkItemId查询检查小项信息
     *
     * @param checkItemId the checkItem id
     * @return the checkItem by checkItem id
     */
    @ApiOperation(value = "查询检查小项", notes = "查询检查小项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "checkItemId", required = true, value = "检查小项项ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(path = "/checkItems/{checkItemId}", method = RequestMethod.GET)
    public BaseResponse getCheckItemByCheckItemId(@PathVariable("checkItemId") Integer checkItemId) {
        CheckItem checkItem = checkItemService.findCheckItemByCheckItemId(checkItemId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(checkItem);
        return response;
    }

    /**
     * 根据指定参数查询检查小项信息列表
     *
     * @param itemId   the item id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the checkItems
     */
    @ApiOperation(value = "查询检查小项列表", notes = "查询检查小项列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", name = "itemId", required = true, value = "检查大项ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageNum", value = "页数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页条数", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItems", method = RequestMethod.GET)
    public BaseResponse getCheckItems(@RequestParam(value = "itemId", required = true) Integer itemId,
                                      @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        CheckItem checkItem = new CheckItem();
        checkItem.setItemId(itemId);
        PageInfo<CheckItem> pageInfo = checkItemService.findCheckItems(checkItem, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增检查小项信息.
     *
     * @param addCheckItemRequest the add check item request
     * @return the integer
     */
    @ApiOperation(value = "新增检查小项", notes = "新增检查小项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItems", method = RequestMethod.POST)
    public BaseResponse addCheckItem(@RequestBody AddCheckItemRequest addCheckItemRequest) {
        checkItemService.insert(addCheckItemRequest.getCheckItemList());
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 更新检查小项信息.
     *
     * @param updateCheckItemDTO the update check item dto
     * @return the integer
     */
    @ApiOperation(value = "更新检查小项", notes = "更新检查小项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItems", method = RequestMethod.PUT)
    public BaseResponse updateCheckItem(@RequestBody UpdateCheckItemDTO updateCheckItemDTO) {
        checkItemService.updateCheckItems(updateCheckItemDTO);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 根据指定的checkItemId删除检查小项信息
     *
     * @param checkItemId the checkItem id
     * @return the integer
     */
    @ApiOperation(value = "删除检查小项", notes = "删除检查小项")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "path", name = "checkItemId", required = true, value = "检查小项项ID", dataType = "Integer"),
            @ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/checkItems/{checkItemId}", method = RequestMethod.DELETE)
    public BaseResponse deleteCheckItem(@PathVariable("checkItemId") Integer checkItemId) {
        checkItemService.deleteByCheckItemId(checkItemId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

}
