package com.yukkyapp;

public class Log {
    public String name;
    public String[] tags;
    public String desc;
    public Object infos;

    public Log(String name, String[] tags, String desc, Object infos) {
        this.name = name;
        this.tags = tags;
        this.desc = desc;
        this.infos = infos;
    }
}