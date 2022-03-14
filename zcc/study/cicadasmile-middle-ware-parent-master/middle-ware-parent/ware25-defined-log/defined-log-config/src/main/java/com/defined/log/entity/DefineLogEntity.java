package com.defined.log.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("dt_defined_log")
public class DefineLogEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id ;            // 主键ID
    private String className ;      // 类名
    private String methodName ;     // 方法名
    private Integer apiType ;       // API类型
    private String methodDesc ;     // 方法描述
    private Integer bizNature ;     // 业务性质
    private Integer dataFlowType ;  // 数据流
    private String reqParam ;       // 请求报文
    private String resParam ;       // 响应报文

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getApiType() {
        return apiType;
    }

    public void setApiType(Integer apiType) {
        this.apiType = apiType;
    }

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    public Integer getBizNature() {
        return bizNature;
    }

    public void setBizNature(Integer bizNature) {
        this.bizNature = bizNature;
    }

    public Integer getDataFlowType() {
        return dataFlowType;
    }

    public void setDataFlowType(Integer dataFlowType) {
        this.dataFlowType = dataFlowType;
    }

    public String getReqParam() {
        return reqParam;
    }

    public void setReqParam(String reqParam) {
        this.reqParam = reqParam;
    }

    public String getResParam() {
        return resParam;
    }

    public void setResParam(String resParam) {
        this.resParam = resParam;
    }
}
