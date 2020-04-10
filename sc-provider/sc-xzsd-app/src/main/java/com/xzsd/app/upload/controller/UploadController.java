package com.xzsd.app.upload.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.upload.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 图片上传到腾讯云对象存储
 * @author zhaorujie
 * @date 2020-3-28
 */
@RestController
@RequestMapping("/image")
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Resource
    private UploadService uploadService;

    /**
     * 图片上传
     * @param imageFile
     * @return
     * @author zhaorujie
     * @date 2020-3-28
     */
    @PostMapping("uploadImage")
    public AppResponse imagesUpload(List<MultipartFile> imageFile) {
        try{
            return uploadService.imagesUpload(imageFile);
        }catch (Exception e){
            logger.error("图片上传失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
