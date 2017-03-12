package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.RegionDTO;
import com.chinamobile.iot.lightapp.mysql.model.Region;
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
public interface RegionService {


    /**
     * find regions.
     *
     * @param region     the region
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the regions
     */
    public PageInfo<RegionDTO> findRegions(Region region, Integer userId, Integer pageNum, Integer pageSize);

    /**
     * find region by region id.
     *
     * @param regionId the region id
     * @return the region by region id
     */
    public Region findRegionByRegionId(Integer regionId);

    /**
     * Delete by region id int.
     *
     * @param regionId the region id
     * @return the int
     */
    @Transactional
    public int deleteByRegionId(Integer regionId);

    /**
     * Update by region id int.
     *
     * @param region the region
     * @return the int
     */
    @Transactional
    public int updateByRegionId(Region region);

    /**
     * Insert int.
     *
     * @param region the region
     * @return the int
     */
    @Transactional
    public int insert(Region region);
}
