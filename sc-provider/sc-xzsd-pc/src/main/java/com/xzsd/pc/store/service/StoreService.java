package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    @Resource
    private UserDao userDao;

    /**
     * 新增门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        //校验是否存在相同的营业执政编码
        int countBusinessCode = storeDao.countBusinessCode(storeInfo);
        if(countBusinessCode != 0){
            return AppResponse.bizError("营业执照编码已存在，请重新输入！");
        }
        //校验店长的编号是否存在
        StoreInfo managerId = storeDao.getManagerId(storeInfo);
        if(managerId == null){
            return AppResponse.bizError("该店长编号不存在，请重新输入！");
        }
        storeInfo.setStoreCode(StringUtil.getCommonCode(2));
        storeInfo.setIsDelete(0);
        //新增门店信息
        int store = storeDao.addStore(storeInfo);
        if(store == 0){
            return AppResponse.bizError("新增失败");
        }
        return AppResponse.success("新增门店信息成功");
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    StoreVO globalStoreInfo = null;
    public AppResponse getStoreInfoById(String storeCode){
        globalStoreInfo = storeDao.getStoreInfoById(storeCode);
        if(globalStoreInfo == null){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功", globalStoreInfo);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        //校验店长编号是否存在
        StoreInfo managerId = storeDao.getManagerId(storeInfo);
        if(managerId == null){
            return AppResponse.success("该店长编号不存在，请重新输入！");
        }
        //校验营业执政编码是否存在
        int count = storeDao.countBusinessCode(storeInfo);
        if(count != 0 && globalStoreInfo.getBusinessCode().equals(storeInfo.getBusinessCode()) == false){
            return AppResponse.success("营业执照编码已存在，请重新输入！");
        }

        int store = storeDao.updateStore(storeInfo);
        if(store == 0){
            return AppResponse.success("修改门店信息失败");
        }
        return AppResponse.success("修改门店信息成功");
    }

    /**
     * 查询门店信息列表（分页）
     * @param storeInfo
     * @return
     * @Author zhaorujie
     * @Date 2020-03-26
     */
    public AppResponse getListStore(StoreInfo storeInfo){
        PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
        List<StoreVO> listStore = storeDao.getListStore(storeInfo);
        PageInfo<StoreVO> pageData = new PageInfo<>(listStore);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除门店信息
     * @param storeCode
     * @param userId
     * @return
     */
    public AppResponse deleteStoreById(String storeCode, String userId){
        //分离字符串
        List<String> listStoreCode = Arrays.asList(storeCode.split(","));
        int count = storeDao.deleteStoreById(listStoreCode, userId);
        if(count == 0){
            return AppResponse.bizError("删除失败！");
        }
        return AppResponse.success("删除成功！");
    }
}
