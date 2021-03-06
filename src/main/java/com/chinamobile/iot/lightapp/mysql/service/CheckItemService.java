package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.dto.UpdateCheckItemDTO;
import com.chinamobile.iot.lightapp.mysql.model.CheckItem;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The devices service.
 *
 * @author sxt
 * @since 2016.10.25
 */
@Service
public interface CheckItemService {


    /**
     * find checkItems.
     *
     * @param checkItem the checkItem
     * @param pageNum   the page num
     * @param pageSize  the page size
     * @return the checkItems
     */
    public PageInfo<CheckItem> findCheckItems(CheckItem checkItem, Integer pageNum, Integer pageSize);

    /**
     * find checkItem by checkItem id.
     *
     * @param checkItemId the checkItem id
     * @return the checkItem by checkItem id
     */
    public CheckItem findCheckItemByCheckItemId(Integer checkItemId);

    /**
     * Delete by checkItem id int.
     *
     * @param checkItemId the checkItem id
     * @return the int
     */
    @Transactional
    public int deleteByCheckItemId(Integer checkItemId);

    /**
     * Update by checkItem id int.
     *
     * @param checkItem the checkItem
     * @return the int
     */
    @Transactional
    public int updateByCheckItemId(CheckItem checkItem);

    /**
     * Update check items int.
     *
     * @param updateCheckItemDTO the update check item dto
     * @return the int
     */
    @Transactional
    int updateCheckItems(UpdateCheckItemDTO updateCheckItemDTO);

    /**
     * Insert int.
     *
     * @param checkItemList the check item list
     * @return the int
     */
    @Transactional
    public int insert(List<CheckItem> checkItemList);
}
