package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.config.SecurityUtils;
import com.chinamobile.iot.lightapp.mysql.dto.RegionDTO;
import com.chinamobile.iot.lightapp.mysql.model.Region;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.RegionService;
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
@Api("区域管理")
public class RegionController {
    private static Logger logger = LoggerFactory.getLogger(RegionController.class);
    @Autowired
    private RegionService regionService;

    /**
     * 根据指定regionId查询区域信息
     *
     * @param regionId the region id
     * @return the region by region id
     */
    @RequestMapping(path = "/regions/{regionId}", method = RequestMethod.GET)
    public Region getRegionByRegionId(@PathVariable("regionId") Integer regionId) {
        return regionService.findRegionByRegionId(regionId);
    }

    /**
     * 根据指定参数查询区域信息列表
     *
     * @param regionName the region name
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the regions
     */

    @RequestMapping(value = "/regions", method = RequestMethod.GET)
    public PageInfo<RegionDTO> getRegions(@RequestParam(value = "regionName", required = false) String regionName,
                                          @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", required = false, defaultValue = "0") Integer pageSize) {
        Region region = new Region();
        region.setRegionName(regionName);
        Integer userId = SecurityUtils.getCurrentUserId();
        return regionService.findRegions(region,userId, pageNum, pageSize);
    }

    /**
     * 新增区域信息.
     *
     * @param region the add region request
     * @return the integer
     */
    @RequestMapping(value = "/regions", method = RequestMethod.POST)
    public BaseResponse addRegion(@RequestBody Region region) {
        regionService.insert(region);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        return response;
    }

    /**
     * 更新区域信息.
     *
     * @param region the update region request
     * @return the integer
     */
    @RequestMapping(value = "/regions", method = RequestMethod.PUT)
    public BaseResponse updateRegion(@RequestBody Region region) {
        regionService.updateByRegionId(region);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        return response;
    }

    /**
     * 根据指定的regionId删除区域信息
     *
     * @param regionId the region id
     * @return the integer
     */
    @RequestMapping(value = "/regions/{regionId}", method = RequestMethod.DELETE)
    public BaseResponse deleteRegion(@PathVariable("regionId") Integer regionId) {
        regionService.deleteByRegionId(regionId);
        BaseResponse response = new BaseResponse();
        response.setMsg("成功!");
        return response;
    }

}
