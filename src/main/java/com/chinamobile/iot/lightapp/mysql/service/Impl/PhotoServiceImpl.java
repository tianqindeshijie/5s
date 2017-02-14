package com.chinamobile.iot.lightapp.mysql.service.Impl;


import com.chinamobile.iot.lightapp.mysql.dao.PhotoMapper;
import com.chinamobile.iot.lightapp.mysql.model.Photo;
import com.chinamobile.iot.lightapp.mysql.model.PhotoExample;
import com.chinamobile.iot.lightapp.mysql.service.PhotoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The devices Service Impl.
 *
 * @author sxt
 * @since 2016.10.25
 */

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;

    @Override
    public PageInfo<Photo> findPhotos(Photo photo, Integer pageNum, Integer pageSize) {
        PhotoExample photoExample = new PhotoExample();
        PhotoExample.Criteria criteria = photoExample.createCriteria();


        PageHelper.startPage(pageNum, pageSize,true,false);
        List<Photo> list= photoMapper.selectByExample(photoExample);
        return new PageInfo<Photo>(list);
    }

    @Override
    public Photo findPhotoByPhotoId(Integer photoId) {
        return photoMapper.selectByPrimaryKey(photoId);
    }

    @Override
    public int deleteByPhotoId(Integer photoId) {
        return photoMapper.deleteByPrimaryKey(photoId);
    }

    @Override
    public int updateByPhotoId(Photo photo) {
        return photoMapper.updateByPrimaryKeySelective(photo);
    }

    @Override
    public int insert(Photo photo) {
        return photoMapper.insertSelective(photo);
    }

}
