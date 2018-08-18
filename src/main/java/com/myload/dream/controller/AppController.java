package com.myload.dream.controller;

import com.myload.dream.bean.ResponseResult;
import com.myload.dream.redis.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: putao
 * @Date: 2018/8/13
 */
@RestController
public class AppController {



    @RequestMapping("/getMessageList")
    public ResponseResult start(HttpServletResponse rsp) {

        String msg = RedisUtil.getJedis().get("msg");
        rsp.addHeader("Access-Control-Allow-Origin", "*");
        return ResponseResult.success(msg);
    }
    @RequestMapping(value = "/postKeyData", method = RequestMethod.POST)
    public String post_data(String key,String content,HttpServletResponse rsp){
        try {
            if(key == null || key.length() == 0){
                return "error";
            }
            Jedis jedis = RedisUtil.getJedis();
            jedis.set(key,content);
            rsp.addHeader("Access-Control-Allow-Origin", "*");
            RedisUtil.releaseResource(jedis);
            return "success";
        }catch (Exception e){
            return "error";
        }

    }


    @RequestMapping(value = "/getKeyData")
    public String post_data(String key, HttpServletResponse rsp, HttpServletRequest request){
        try {
            if(key == null || key.length() == 0){
                return "no data";
            }
            String remoteAddr = request.getRemoteAddr();



            Jedis jedis = RedisUtil.getJedis();
            String content = jedis.get(key);
            jedis.set("ip",remoteAddr);

            RedisUtil.releaseResource(jedis);

            rsp.addHeader("Access-Control-Allow-Origin", "*");

            return content;
        }catch (Exception e){
            return "no data";
        }

    }



}
