package com.myload.dream.controller;

import com.myload.dream.bean.ResponseResult;
import com.myload.dream.redis.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: putao
 * @Date: 2018/8/13
 */
@RestController
public class AppController {



    @RequestMapping("/getMessageList")
    public ResponseResult start() {
        RedisUtil.getJedis().set("msg","testtesttest");
        String msg = RedisUtil.getJedis().get("msg");
        return ResponseResult.success(msg);
    }

}
