package com.defined.log.model;

public enum DataFlowEnum {

    DEFAULT(1, "默认不处理"),
    LOG_MQ(2, "日志MQ队列"),
    LOG_REDIS(3, "Redis缓存");

    private Integer dataFlowType;

    private String dataFlowDesc;

    DataFlowEnum (int dataFlowType, String dataFlowDesc) {
        this.dataFlowType = dataFlowType;
        this.dataFlowDesc = dataFlowDesc;
    }

    public Integer getDataFlowType() {
        return dataFlowType;
    }

    public String getDataFlowDesc() {
        return dataFlowDesc;
    }
}
