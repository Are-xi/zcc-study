package com.defined.log.entity;

import org.springframework.beans.factory.annotation.Value;

public class DefineLogModel extends DefineLogEntity {

    private String appId ;          // 应用ID
    private String apiTypeDesc ;    // API类型描述
    private boolean isSaveReqParam ;// 是否存入参
    private boolean isSaveResParam ;// 是否存返参
    private boolean isAsync ;       // 是否异步处理

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getApiTypeDesc() {
        return apiTypeDesc;
    }

    public void setApiTypeDesc(String apiTypeDesc) {
        this.apiTypeDesc = apiTypeDesc;
    }
    public boolean isSaveReqParam() {
        return isSaveReqParam;
    }

    public void setSaveReqParam(boolean saveReqParam) {
        isSaveReqParam = saveReqParam;
    }

    public boolean isSaveResParam() {
        return isSaveResParam;
    }

    public void setSaveResParam(boolean saveResParam) {
        isSaveResParam = saveResParam;
    }

    public boolean isAsync() {
        return isAsync;
    }

    public void setAsync(boolean async) {
        isAsync = async;
    }
}
