package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.CheckItemMapper;
import com.chinamobile.iot.lightapp.mysql.model.CheckItem;
import com.chinamobile.iot.lightapp.mysql.model.CheckItemExample;
import com.chinamobile.iot.lightapp.mysql.service.CheckItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public PageInfo<CheckItem> findCheckItems(CheckItem checkItem, Integer pageNum, Integer pageSize) {
        CheckItemExample checkItemExample = new CheckItemExample();
        CheckItemExample.Criteria criteria = checkItemExample.createCriteria();
        criteria.andItemIdEqualTo(checkItem.getItemId());

        PageHelper.startPage(pageNum, pageSize, true, false);
        List<CheckItem> list = checkItemMapper.selectByExample(checkItemExample);
        return new PageInfo<CheckItem>(list);
    }

    @Override
    public CheckItem findCheckItemByCheckItemId(Integer checkItemId) {
        return checkItemMapper.selectByPrimaryKey(checkItemId);
    }

    @Override
    public int deleteByCheckItemId(Integer checkItemId) {
        return checkItemMapper.deleteByPrimaryKey(checkItemId);
    }

    @Override
    public int updateByCheckItemId(CheckItem checkItem) {
        return checkItemMapper.updateByPrimaryKeySelective(checkItem);
    }

    @Override
    public int insert(List<CheckItem> checkItemList) {
        if (CollectionUtils.isEmpty(checkItemList)) {
            throw new RuntimeException("no check item to add!");
        }
        for (CheckItem checkItem : checkItemList) {
            checkItemMapper.insertSelective(checkItem);
        }
        return 0;
    }

}
