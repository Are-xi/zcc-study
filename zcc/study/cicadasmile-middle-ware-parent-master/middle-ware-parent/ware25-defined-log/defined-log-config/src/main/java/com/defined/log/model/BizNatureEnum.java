package com.defined.log.model;

public enum BizNatureEnum {

    DEFAULT (1, "默认普通"),
    BIZ_PUSH(2, "推送营销"),
    BIZ_ANALYZE(3, "行为分析");

    private Integer bizNature;
    private String bizNatureDesc;

    BizNatureEnum (int bizNature, String bizNatureDesc) {
        this.bizNature = bizNature;
        this.bizNatureDesc = bizNatureDesc;
    }

    public Integer getBizNature() {
        return bizNature;
    }

    public String getBizNatureDesc() {
        return bizNatureDesc;
    }
}
