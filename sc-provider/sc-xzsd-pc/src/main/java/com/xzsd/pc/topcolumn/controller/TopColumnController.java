package com.xzsd.pc.topcolumn.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topcolumn.service.TopColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查顶部栏
 * @author zhaorujie
 * @date 2020/4/9
 */
@RestController
@RequestMapping("topOfColumn")
public class TopColumnController {
    public static final Logger logger = LoggerFactory.getLogger(TopColumnController.class);
    @Resource
    private TopColumnService topColumnService;

    /**
     * 查询顶部栏
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    @PostMapping("getTopOfColumn")
    public AppResponse getTopColumn(){
        try {
            String loginUserId = SecurityUtils.getCurrentUserId();
            return topColumnService.getTopColumn(loginUserId);
        }catch (Exception e){
            logger.error("查询顶部栏失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
