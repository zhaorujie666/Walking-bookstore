package com.xzsd.pc.upload.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.upload.entity.Upload;
import com.xzsd.pc.util.COSClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片上传
 * @author zhaorujie
 * @date 2020-3-28
 */
@Service
public class UploadService {

    /**
     * 图片上传
     * @param
     * @return
     * @author zhaorujie
     * @Date 2020-03-29
     */
    public AppResponse imagesUpload(MultipartFile imageFile) {
        COSClientUtil cosClientUtil = new COSClientUtil();
        String name, imgUrl;
        String  url = "";
        try {
                //上传一张图片
                name = cosClientUtil.uploadFile2Cos(imageFile);
                imgUrl = cosClientUtil.getImgUrl(name);
                String[] split = imgUrl.split("\\?");
                url = split[0];
                //listImage.add(split[0])
        }catch (Exception e) {
            e.printStackTrace();
        }
        //封装数据
        Upload upload = new Upload();
        upload.setImagePath(url);
        System.out.println(upload);
        return AppResponse.success("图片上传成功！", upload);
    }

    /**
     * 图片上传
     * @param
     * @return
     * @author zhaorujie
     * @Date 2020-03-29
     *//*
    public AppResponse imagesUpload(List<MultipartFile> imageFile) {
        COSClientUtil cosClientUtil = new COSClientUtil();
        String name, imgUrl;
        String  url = "";
        System.out.println(imageFile.size());
        //List<String> listImage = new ArrayList<>();
        try {
            if(imageFile.size() == 1){
                //上传一张图片
                name = cosClientUtil.uploadFile2Cos(imageFile.get(0));
                imgUrl = cosClientUtil.getImgUrl(name);
                String[] split = imgUrl.split("\\?");
                url = split[0];
                //listImage.add(split[0]);
            }else if(imageFile.size() > 1){
                //上传多张图片
                for (MultipartFile image : imageFile) {
                    name = cosClientUtil.uploadFile2Cos(image);
                    imgUrl = cosClientUtil.getImgUrl(name);
                    String[] split = imgUrl.split("\\?");
                    url = url + split[0] + ",";
                    //listImage.add(split[0]);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //封装数据
        Upload upload = new Upload();
        upload.setImagePath(url);
        return AppResponse.success("图片上传成功！", upload);
    }*/
}
