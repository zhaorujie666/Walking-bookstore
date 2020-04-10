package com.xzsd.pc.slide.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.slide.dao.SlideDao;
import com.xzsd.pc.slide.entity.SlideInfo;
import com.xzsd.pc.slide.entity.SlideVO;
import com.xzsd.pc.upload.service.UploadService;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 实现类
 * @author zhaorujie
 * @date 2020-3-29
 */
@Service
public class SlideService {

    @Resource
    private SlideDao slideDao;

    @Resource
    private UserDao userDao;

    @Resource
    private UploadService uploadService;

    /**
     * 新增轮播图·
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSlide(SlideInfo slideInfo){
        //校验是否存在相同的排序
        int countSort = slideDao.countSort(slideInfo);
        if(countSort != 0){
            return AppResponse.bizError("出现重复的排序，请重新输入！");
        }
        slideInfo.setSlideId(StringUtil.getCommonCode(2));
        int count = slideDao.addSlide(slideInfo);
        if(count == 0){
            return AppResponse.bizError("新增轮播图失败！");
        }
        return AppResponse.success("新增轮播图成功！");
    }

    /**
     * 修改轮播图状态
     * @param slideId
     * @param slideStatus
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideStatus(String slideId,
                                         String slideStatus,
                                         String userId){
        List<String> listSlideId = Arrays.asList(slideId.split(","));
        int count = slideDao.updateSlideStatus(listSlideId, slideStatus, userId);
        if(count == 0){
            return AppResponse.bizError("修改轮播图状态失败！");
        }
        return AppResponse.success("修改轮播图状态成功！");
    }

    /**
     * 查询轮播图列表（分页）
     * @param slideInfo
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    public AppResponse getListSlide(SlideInfo slideInfo){
        PageHelper.startPage(slideInfo.getPageNum(), slideInfo.getPageSize());
        List<SlideVO> listSlide = slideDao.getListSlide(slideInfo);
        PageInfo<SlideVO> pageData = new PageInfo<>(listSlide);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除轮播图
     * @param slideId
     * @param userId
     * @return
     * @author zhaorujie
     * @date 2020-3-29
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlide(String slideId, String userId){
        List<String> listSlideId = Arrays.asList(slideId.split(","));
        int count = slideDao.deleteSlide(listSlideId, userId);
        if(count == 0){
            return AppResponse.bizError("删除轮播图失败！");
        }
        return AppResponse.success("删除轮播图成功！");
    }
}
