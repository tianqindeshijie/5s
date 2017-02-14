package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Region;
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
@Api("模板管理")
public class RegionController {
    private static Logger logger = LoggerFactory.getLogger(RegionController.class);
    @Autowired
    private RegionService regionService;

    /**
     * 根据指定regionId查询模板信息
     *
     * @param regionId the region id
     * @return the region by region id
     */
    @RequestMapping(path = "/regions/{regionId}", method = RequestMethod.GET)
    public Region getRegionByRegionId(@PathVariable("regionId") Integer regionId) {
        return regionService.findRegionByRegionId(regionId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param regionName    the region name
     * @param regionContent the region content
     * @param regionType    the region type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the regions
     */

    @RequestMapping(value = "/regions", method = RequestMethod.GET)
    public PageInfo<Region> getRegions(@RequestParam(value = "regionName", required = false) String regionName,
                                           @RequestParam(value = "regionContent", required = false) String regionContent,
                                           @RequestParam(value = "regionType", required = false) Integer regionType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Region region = new Region();

        return regionService.findRegions(region, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param region the add region request
     * @return the integer
     */
    @RequestMapping(value = "/regions", method = RequestMethod.POST)
    public Integer addRegion(@RequestBody Region region) {
        return regionService.insert(region);
    }

    /**
     * 更新模板信息.
     *
     * @param region the update region request
     * @return the integer
     */
    @RequestMapping(value = "/regions", method = RequestMethod.PUT)
    public Integer updateRegion(@RequestBody Region region) {
        return regionService.updateByRegionId(region);
    }

    /**
     * 根据指定的regionId删除模板信息
     *
     * @param regionId the region id
     * @return the integer
     */
    @RequestMapping(value = "/regions/{regionId}", method = RequestMethod.DELETE)
    public Integer deleteRegion(@PathVariable("regionId") Integer regionId) {
        return regionService.deleteByRegionId(regionId);
    }

}
