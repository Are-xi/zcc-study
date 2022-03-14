package com.defined.log.annotation;

import com.defined.log.model.ApiTypeEnum;
import com.defined.log.model.BizNatureEnum;
import com.defined.log.model.DataFlowEnum;

import java.lang.annotation.*;

/**
 * 自定义日志注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface DefinedLog {

    /**
     * 操作类型
     */
    ApiTypeEnum apiType () ;

    /**
     * 方法描述
     */
    String methodDesc();

    /**
     * 业务性质
     */
    BizNatureEnum bizNature() ;

    /**
     * 数据流向,与业务性质关联
     */
    DataFlowEnum dataFlow() ;

    /**
     * 存储入参
     */
    boolean isSaveReqParam () default true ;

    /**
     * 存储出参
     */
    boolean isSaveResParam() default true ;

    /**
     * 是否需要异步处理
     */
    boolean isAsync () default false ;

}
