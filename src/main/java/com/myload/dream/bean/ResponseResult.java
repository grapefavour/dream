package com.myload.dream.bean;

public class ResponseResult {
    private int code;
    private String msg;
    private Object data;

    public ResponseResult(){
        this.code = 200;
        this.msg = "success";
    }
    public ResponseResult(Object data){
        this.code = 200;
        this.data = data;
        this.msg = "success";
    }
    public ResponseResult(String e){
        this.code = 201;
        this.msg = e;
    }
    public static ResponseResult success(Object data){
        return new ResponseResult(data);
    }
    public static ResponseResult failed(String e){
        return new ResponseResult(e);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}