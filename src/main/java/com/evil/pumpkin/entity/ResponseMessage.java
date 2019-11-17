package com.evil.pumpkin.entity;

public class ResponseMessage {

    public static final Integer OK=200;
    public static final Integer ERROR=500;

    private Integer status;
    private String msg;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }





}
