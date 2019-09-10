package com.yukkyapp;

public class FullLog extends Log {
    private String type;

    public FullLog(String name, String[] tags, String desc, Object infos, String type) {
        super(name, tags, desc, infos);
        this.type = type;
    }

    public FullLog(Log log, String type) {
        super(log.name, log.tags, log.desc, log.infos);
        this.type = type;
    }
}