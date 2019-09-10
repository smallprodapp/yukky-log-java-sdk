package com.yukkyapp;

public class Request {
    private FullLog log;
    private String appkey;
    private String appsecret;

    public Request(FullLog log, String appkey, String appsecret) {
        this.log = log;
        this.appkey = appkey;
        this.appsecret = appsecret;
    }
}