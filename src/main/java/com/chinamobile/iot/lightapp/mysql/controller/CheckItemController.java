package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.CheckItem;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemService;
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
@RequestMapping("/mysql")
@Api("模板管理")
public class CheckItemController {
    private static Logger logger = LoggerFactory.getLogger(CheckItemController.class);
    @Autowired
    private CheckItemService checkItemService;

    /**
     * 根据指定checkItemId查询模板信息
     *
     * @param checkItemId the checkItem id
     * @return the checkItem by checkItem id
     */
    @RequestMapping(path = "/checkItems/{checkItemId}", method = RequestMethod.GET)
    public CheckItem getCheckItemByCheckItemId(@PathVariable("checkItemId") Integer checkItemId) {
        return checkItemService.findCheckItemByCheckItemId(checkItemId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param itemId   the item id
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the checkItems
     */
    @RequestMapping(value = "/checkItems", method = RequestMethod.GET)
    public BaseResponse getCheckItems(@RequestParam(value = "itemId", required = false) Integer itemId,
                                      @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        CheckItem checkItem = new CheckItem();
        checkItem.setItemId(itemId);
        PageInfo<CheckItem> pageInfo = checkItemService.findCheckItems(checkItem, pageNum, pageSize);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        response.setData(pageInfo);
        return response;
    }

    /**
     * 新增模板信息.
     *
     * @param checkItem the add checkItem request
     * @return the integer
     */
    @RequestMapping(value = "/checkItems", method = RequestMethod.POST)
    public BaseResponse addCheckItem(@RequestBody CheckItem checkItem) {
        checkItemService.insert(checkItem);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新模板信息.
     *
     * @param checkItem the update checkItem request
     * @return the integer
     */
    @RequestMapping(value = "/checkItems", method = RequestMethod.PUT)
    public BaseResponse updateCheckItem(@RequestBody CheckItem checkItem) {
        checkItemService.updateByCheckItemId(checkItem);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的checkItemId删除模板信息
     *
     * @param checkItemId the checkItem id
     * @return the integer
     */
    @RequestMapping(value = "/checkItems/{checkItemId}", method = RequestMethod.DELETE)
    public BaseResponse deleteCheckItem(@PathVariable("checkItemId") Integer checkItemId) {
        checkItemService.deleteByCheckItemId(checkItemId);
        BaseResponse response = new BaseResponse();
        response.setCode(200);
        response.setMsg("成功!");
        return response;
    }

}
