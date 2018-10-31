package com.lzw.servicepro.service;

import com.lzw.servicepro.annotations.DoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserBiz {

    private Logger logger = Logger.getLogger(UserBiz.class);

    @Autowired
    private CacheBiz cacheBiz;  //缓存与本自的业务没有关系，这其实是多余的耦合

    public String getUserInfo(Long id){
        logger.info("id:"+id);
        String info = cacheBiz.getInfo(id);  //缓存与本自的业务没有关系，这其实是多余的耦合
        if(StringUtils.isEmpty(info))
            //模拟查询数据库
            info = "id:"+id+" name:王xx";
        return info;
    }

    @DoService(cache = "#id") //通过注解实现解耦,种类的#是站位符，必须和方法中的参数名称一致
    public String getUserInfoByAnnotation(Long id){
        String info = cacheBiz.getInfo(id);
        if(StringUtils.isEmpty(info))
            //模拟查询数据库
            info = "id:"+id+" name:王xx";
        return info;
    }


}
