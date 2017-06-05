package com.chinamobile.iot.lightapp.mysql.controller;

import com.chinamobile.iot.lightapp.mysql.config.Constant;
import com.chinamobile.iot.lightapp.mysql.dto.TestDTO;
import com.chinamobile.iot.lightapp.mysql.dto.UploadItemPhotoVO;
import com.chinamobile.iot.lightapp.mysql.response.BaseResponse;
import com.chinamobile.iot.lightapp.mysql.service.FileUploadService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
     * @param userId the user id
     * @param file   the file
     * @return the string
     */
    @ApiOperation(value = "上传用户头像", notes = "上传用户头像")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/user/photo/upload", method = RequestMethod.POST)
    public BaseResponse uploadUserPhoto(@RequestParam("userId") Integer userId, @RequestParam("file") MultipartFile file) {
        fileUploadService.saveUserPhoto(userId, file);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param workCycleId the work cycle id
     * @param file        the file
     * @return the string
     */
    @ApiOperation(value = "上传工作圈头像", notes = "上传工作圈头像")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/workcycle/photo/upload", method = RequestMethod.POST)
    public BaseResponse uploadWorkCyclePhoto(@RequestParam("workCycleId") Integer workCycleId, @RequestParam("file") MultipartFile file) {
        fileUploadService.saveWorkcyclePhoto(workCycleId, file);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

    /**
     * Upload check item photo base response.
     *
     * @param uploadItemPhotoVO the upload item photo vo
     * @return the base response
     */
    @ApiOperation(value = "上传检查大项照片", notes = "上传检查大项照片")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportitem/photo/upload", method = RequestMethod.POST)
    public BaseResponse uploadCheckItemPhoto(@RequestBody UploadItemPhotoVO uploadItemPhotoVO) {
        fileUploadService.saveReportItemPhoto(uploadItemPhotoVO.getReportItemScoreId(), uploadItemPhotoVO.getFiles());
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }

/*    *//**
     * 删除检查大项图片
     *
     * @param reportItemScoreId the report item score id
     * @param photoId           the photo id
     * @return the string
     *//*
    @ApiOperation(value = "删除检查大项照片", notes = "删除检查大项照片")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/reportitem/photo/delete", method = RequestMethod.POST)
    public BaseResponse deleteReportItemPhoto(@RequestParam("reportItemScoreId") Integer reportItemScoreId, @RequestParam("photoId") Integer photoId) {
        fileUploadService.deleteReportItemPhoto(reportItemScoreId, photoId);
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }*/

    /**
     * Download file response entity.
     *
     * @param photoId the photo id
     * @return the response entity
     * @throws IOException the io exception
     */
    @ApiOperation(value = "下载文件", notes = "下载文件")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/download/photo", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadFile(@RequestParam("photoId") Integer photoId) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        String filePath = fileUploadService.downloadFile(photoId);
        Resource resource = new PathResource(filePath);
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(resource.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(resource.getInputStream()));
    }


    /*@ApiOperation(value = "下载文件2", notes = "下载文件2")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/download/photo2", method = RequestMethod.GET)
    public void getDownload(@RequestParam("fileId") Integer fileId, HttpServletResponse response) {
        try {
            // Get your file stream from wherever.
            String filePath = fileUploadService.downloadFile(fileId);
            Resource resource = new PathResource(filePath);
            // Set the content type and attachment header.
            response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.addHeader("Pragma", "no-cache");
            response.addHeader("Expires", "0");
            response.setContentLengthLong(resource.contentLength());
            response.setContentType(MediaType.parseMediaType("application/octet-stream").getType());
            // Copy the stream to the response's output stream.
            IOUtils.copy(resource.getInputStream(), response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {

        }

    }*/

    /**
     * 新增检查小项评分信息.
     *
     * @param
     * @return the integer
     */
    @ApiOperation(value = "上传多个文件", notes = "上传多个文件")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "session-token", value = "session-token", required = true, dataType = "String")})
    @RequestMapping(value = "/uploadMultifiles", method = RequestMethod.POST)
    public BaseResponse uploadMultifiles(@RequestBody TestDTO testDTO, @RequestParam("files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            fileUploadService.saveUploadedFiles(file);
        }
        BaseResponse response = new BaseResponse();
        response.setCode(Constant.SUCCESS_CODE);
        response.setMsg(Constant.SUCCESS_MSG);
        return response;
    }
}
