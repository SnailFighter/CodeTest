package com.lzw.servicepro.service;

import org.springframework.stereotype.Service;

/**
 * 模拟从redis中获取数据
 */

@Service
public class CacheBiz {

    public String getInfo(Long id){
        return "id:"+id+" name: 王xx";
    }

}
