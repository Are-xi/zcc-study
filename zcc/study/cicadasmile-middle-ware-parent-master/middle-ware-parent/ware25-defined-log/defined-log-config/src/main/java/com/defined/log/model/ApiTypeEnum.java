package com.defined.log.model;

public enum ApiTypeEnum {

    INSERT(1, "新增"),
    SELECT(2, "查询"),
    UPDATE(3, "更新"),
    DELETE(4, "删除"),
    COMPOSITE(5, "复合业务");

    private Integer apiType;

    private String apiTypeDesc;

    ApiTypeEnum (int apiType, String apiTypeDesc) {
        this.apiType = apiType;
        this.apiTypeDesc = apiTypeDesc;
    }

    public Integer getApiType() {
        return apiType;
    }

    public String getApiTypeDesc() {
        return apiTypeDesc;
    }
}
