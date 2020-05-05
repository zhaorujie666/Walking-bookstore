package com.xzsd.pc.category.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.category.dao.CategoryDao;
import com.xzsd.pc.category.entity.CategoryList;
import com.xzsd.pc.category.entity.GoodsCategory;
import com.xzsd.pc.category.entity.GoodsCategoryVO;
import com.xzsd.pc.category.entity.SecondCategoryVO;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @DescriptionDemo 商品分类的实现类
 * @author zhaorujie
 * @date 2020-03-25
 */
@Service
public class CategoryService {
    @Resource
    private CategoryDao categoryDao;

    /**
     * 新增商品分类
     * @param goodsCategory
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsCategory(GoodsCategory goodsCategory){
        goodsCategory.setClassifyId(StringUtil.getCommonCode(2));
        //判断是否插入成功
        int categoryNum = categoryDao.addGoodsCategory(goodsCategory);
        if(categoryNum == 0){
            return AppResponse.versionError("新增失败！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询商品分类详情
     * @param categoryId
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    public AppResponse getGoodsCategoryById(String categoryId){
        GoodsCategoryVO goodsCategory = categoryDao.getGoodsCategoryById(categoryId);
        if(goodsCategory == null){
            return AppResponse.versionError("查询分类详情失败！");
        }
        return AppResponse.success("查询分类详情成功！", goodsCategory);
    }

    /**
     * 修改商品分类信息
     * @param goodsCategory
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsCategoryById(GoodsCategory goodsCategory){
        int categoryNum = categoryDao.updateGoodsCategoryById(goodsCategory);
        if(categoryNum == 0){
            return AppResponse.versionError("修改失败！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 查询商品分类列表
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    public AppResponse getListGoodsCategory(){
        List<GoodsCategoryVO> listGoodsCategory = categoryDao.getListFirstAndSecondGoodsCategory();
        List<GoodsCategoryVO> goodsCategoryList = new ArrayList<>();
        //把二级分类拼接到一级分类上
        for (int i = 0; i < listGoodsCategory.size(); i++) {
            List<GoodsCategoryVO> secondCategoryList = new ArrayList<>();
            for (int j = 0; j < listGoodsCategory.size(); j++){
                if(listGoodsCategory.get(i).getClassifyId().equals(listGoodsCategory.get(j).getClassifyParent())){
                    secondCategoryList.add(listGoodsCategory.get(j));
                }
            }
            listGoodsCategory.get(i).setTwoClassifyList(secondCategoryList);
            //父级id为0就添加到集合里
            if("0".equals(listGoodsCategory.get(i).getClassifyParent())){
                goodsCategoryList.add(listGoodsCategory.get(i));
            }
        }
        //封装数据
        CategoryList categoryList = new CategoryList();
        categoryList.setOneClassifyList(goodsCategoryList);
        return AppResponse.success("查询商品分类列表成功！", categoryList);
    }

    /**
     * 删除商品分类
     * @param categoryId
     * @param loginId
     * @param classifyParent
     * @return
     * @author zhaorujie
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsCategory(String categoryId, String loginId, String classifyParent){
        //查询是否存在二级分类
        if("0".equals(classifyParent)){
            int num = categoryDao.countParentId(categoryId);
            if(num != 0){
                return AppResponse.versionError("存在二级分类，不能被删除！");
            }
        }else{
            //查询当前分页下是否有商品
            int cnt = categoryDao.countGoods(categoryId);
            if(cnt != 0){
                return AppResponse.versionError("当前分类存在商品，不能被删除！");
            }
        }
        int count = categoryDao.deleteGoodsCategory(categoryId, loginId);
        if(count == 0){
            return AppResponse.versionError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
