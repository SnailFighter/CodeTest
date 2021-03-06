package com.lzw.servicepro.rest;

import com.lzw.servicepro.service.UserBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping(value = "/")
public class HelloController {
    @Autowired
    UserBiz userBiz;

    TreeMap treeMap;

    Hashtable hashTable;

    ConcurrentHashMap concurrentHashMap;

    Vector vector;

    ThreadLocal<Object> threadLocal = new ThreadLocal<>();


    @RequestMapping(value = "hello")
    public String hello(){
        return "你好！";
    }

    @RequestMapping(value = "{id}")
    public String info(@PathVariable Long id){
        return userBiz.getUserInfo(id);
    }

    @RequestMapping(value = "cache/{id}/")
    public String infocache(@PathVariable Long id){
        return userBiz.getUserInfoByAnnotation(id);
    }


}


