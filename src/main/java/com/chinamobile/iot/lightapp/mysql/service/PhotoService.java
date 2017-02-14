package com.chinamobile.iot.lightapp.mysql.service;

import com.chinamobile.iot.lightapp.mysql.model.Photo;
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
public interface PhotoService {


    /**
     * find photos.
     *
     * @param photo     the photo
     * @param pageNum  the page num
     * @param pageSize the page size
     * @return the photos
     */
    public PageInfo<Photo> findPhotos(Photo photo, Integer pageNum, Integer pageSize);

    /**
     * find photo by photo id.
     *
     * @param photoId the photo id
     * @return the photo by photo id
     */
    public Photo findPhotoByPhotoId(Integer photoId);

    /**
     * Delete by photo id int.
     *
     * @param photoId the photo id
     * @return the int
     */
    @Transactional
    public int deleteByPhotoId(Integer photoId);

    /**
     * Update by photo id int.
     *
     * @param photo the photo
     * @return the int
     */
    @Transactional
    public int updateByPhotoId(Photo photo);

    /**
     * Insert int.
     *
     * @param photo the photo
     * @return the int
     */
    @Transactional
    public int insert(Photo photo);
}
