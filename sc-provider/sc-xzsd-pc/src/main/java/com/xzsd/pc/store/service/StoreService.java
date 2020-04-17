package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.RandomUtil;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 门店的实现类
 * @Author zhaorujie
 * @Date 2020-03-25
 */
@Service
public class StoreService {

    @Resource
    private StoreDao storeDao;

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
            return AppResponse.versionError("营业执照编码已存在，请重新输入！");
        }
        //校验店长的编号是否存在
        StoreInfo managerId = storeDao.getManagerId(storeInfo);
        if(managerId == null){
            return AppResponse.versionError("该店长编号不存在，请重新输入！");
        }
        storeInfo.setStoreId(StringUtil.getCommonCode(2));
        storeInfo.setIsDelete(0);
        //设置随机邀请码
        storeInfo.setInviteCode(RandomUtil.randomLetter(6));
        //校验邀请码是否重复
        int inviteCode = storeDao.countInviteCode(storeInfo);
        while(inviteCode != 0){
            //设置随机邀请码
            storeInfo.setInviteCode(RandomUtil.randomLetter(6));
            inviteCode = storeDao.countInviteCode(storeInfo);
        }
        //新增门店信息
        int store = storeDao.addStore(storeInfo);
        if(store == 0){
            return AppResponse.versionError("新增失败");
        }
        return AppResponse.success("新增门店信息成功");
    }

    /**
     * 查询门店详情
     * @param storeId
     * @return
     */
    public AppResponse getStoreInfoById(String storeId){
        StoreVO storeInfo = storeDao.getStoreInfoById(storeId);
        if(storeInfo == null){
            return AppResponse.versionError("查询失败");
        }
        return AppResponse.success("查询成功", storeInfo);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        StoreVO store = storeDao.getStoreInfoById(storeInfo.getStoreId());
        //判断店长id有没有修改
        if(!store.getUserId().equals(storeInfo.getUserId()) ){
            //校验店长编号是否存在
            StoreInfo managerId = storeDao.getManagerId(storeInfo);
            if(managerId == null){
                return AppResponse.versionError("该店长编号不存在，请重新输入！");
            }
        }
        //判断营业执政编码有没有修改
        if(!store.getBusinessCode().equals(storeInfo.getBusinessCode())){
            //校验营业执政编码是否存在
            int count = storeDao.countBusinessCode(storeInfo);
            if(count != 0){
                return AppResponse.versionError("营业执照编码已存在，请重新输入！");
            }
        }
        //更新门店
        int num = storeDao.updateStore(storeInfo);
        if(num == 0){
            return AppResponse.versionError("修改门店信息失败");
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
        List<StoreVO> listStore = null;
        PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
        //店长查询自己的门店，管理员查询所有门店
        if("2".equals(storeInfo.getRole())){
            listStore = storeDao.getListStore(storeInfo);
        }else if("0".equals(storeInfo.getRole()) || "1".equals(storeInfo.getRole())){
            listStore = storeDao.getListStoreByAdmin(storeInfo);
        }
        PageInfo<StoreVO> pageData = new PageInfo<>(listStore);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * 删除门店信息
     * @param storeId
     * @param loginUserId
     * @return
     */
    public AppResponse deleteStoreById(String storeId, String loginUserId){
        //分离字符串
        List<String> listStoreId = Arrays.asList(storeId.split(","));
        int count = storeDao.deleteStoreById(listStoreId, loginUserId);
        if(count == 0){
            return AppResponse.versionError("删除失败！");
        }
        return AppResponse.success("删除成功！");
    }
}
