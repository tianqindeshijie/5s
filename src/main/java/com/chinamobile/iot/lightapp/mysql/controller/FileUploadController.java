package com.chinamobile.iot.lightapp.mysql.controller;
/*

*/
/**
 * Created by xuetao on 2017/5/9.
 * <p>
 * 文件上传的Controller
 *
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 * <p>
 * 文件上传的Controller
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 *//*


*/
/**
 * 文件上传的Controller
 *
 * @author 单红宇(CSDN CATOOP)
 * @create 2017年3月11日
 */


import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * The type File upload controller.
 */
@RestController
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file the file
     * @return the string
     */
    @RequestMapping(value = "/user/photo/upload", method = RequestMethod.POST)
    public BaseResponse upload(@RequestParam("userId") Integer userId, @RequestParam("file") MultipartFile file) {
        fileUploadService.saveFile(userId, file);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }
}
