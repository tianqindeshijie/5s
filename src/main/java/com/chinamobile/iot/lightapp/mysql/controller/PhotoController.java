package com.chinamobile.iot.lightapp.mysql.controller;


import com.chinamobile.iot.lightapp.mysql.model.Photo;
import com.chinamobile.iot.lightapp.mysql.service.PhotoService;
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

@Api("模板管理")
public class PhotoController {
    private static Logger logger = LoggerFactory.getLogger(PhotoController.class);
    @Autowired
    private PhotoService photoService;

    /**
     * 根据指定photoId查询模板信息
     *
     * @param photoId the photo id
     * @return the photo by photo id
     */
    @RequestMapping(path = "/photos/{photoId}", method = RequestMethod.GET)
    public Photo getPhotoByPhotoId(@PathVariable("photoId") Integer photoId) {
        return photoService.findPhotoByPhotoId(photoId);
    }

    /**
     * 根据指定参数查询模板信息列表
     *
     * @param photoName    the photo name
     * @param photoContent the photo content
     * @param photoType    the photo type
     * @param pageNum    the page num
     * @param pageSize   the page size
     * @return the photos
     */

    @RequestMapping(value = "/photos", method = RequestMethod.GET)
    public PageInfo<Photo> getPhotos(@RequestParam(value = "photoName", required = false) String photoName,
                                           @RequestParam(value = "photoContent", required = false) String photoContent,
                                           @RequestParam(value = "photoType", required = false) Integer photoType,
                                           @RequestParam(value = "pageNum", required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", required = false,defaultValue = "0") Integer pageSize) {
        Photo photo = new Photo();

        return photoService.findPhotos(photo, pageNum, pageSize);
    }

    /**
     * 新增模板信息.
     *
     * @param photo the add photo request
     * @return the integer
     */
    @RequestMapping(value = "/photos", method = RequestMethod.POST)
    public Integer addPhoto(@RequestBody Photo photo) {
        return photoService.insert(photo);
    }

    /**
     * 更新模板信息.
     *
     * @param photo the update photo request
     * @return the integer
     */
    @RequestMapping(value = "/photos", method = RequestMethod.PUT)
    public Integer updatePhoto(@RequestBody Photo photo) {
        return photoService.updateByPhotoId(photo);
    }

    /**
     * 根据指定的photoId删除模板信息
     *
     * @param photoId the photo id
     * @return the integer
     */
    @RequestMapping(value = "/photos/{photoId}", method = RequestMethod.DELETE)
    public Integer deletePhoto(@PathVariable("photoId") Integer photoId) {
        return photoService.deleteByPhotoId(photoId);
    }

}
