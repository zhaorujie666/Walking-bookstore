package com.xzsd.pc.area.service;


import com.xzsd.pc.area.dao.AreaDao;
import com.xzsd.pc.area.entity.AreaList;
import com.xzsd.pc.area.entity.AreaVO;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Service
public class AreaService {

    @Resource
    private AreaDao areaDao;

    /**
     * 查询省市区信息
     * @param parentId
     * @return
     * @Author zhaorujie
     * @Date 2020-03-25
     */
    public AppResponse getListArea(String parentId){
        List<AreaVO> listArea = areaDao.getListArea(parentId);
        if(listArea.size() == 0){
            return AppResponse.bizError("查询失败！");
        }
        //这是为了封装成接口文档需要的名称
        AreaList areaList = new AreaList();
        areaList.setAreaList(listArea);
        return AppResponse.success("查询成功！", areaList);
    }
}
