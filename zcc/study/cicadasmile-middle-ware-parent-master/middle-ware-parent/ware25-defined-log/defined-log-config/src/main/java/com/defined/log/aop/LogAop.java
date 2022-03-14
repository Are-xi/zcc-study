package com.defined.log.aop;

import com.alibaba.fastjson.JSONObject;
import com.defined.log.annotation.DefinedLog;
import com.defined.log.entity.DefineLogModel;
import com.defined.log.service.DefineLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import javax.annotation.Resource;
import java.lang.reflect.Method;

@Component
@Aspect
public class LogAop {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAop.class);

    @Value("${spring.application.app-id}")
    private String appId ;
    @Resource
    private DefineLogService defineLogService ;

    /**
     * 日志切入点
     */
    @Pointcut("@annotation(com.defined.log.annotation.DefinedLog)")
    public void logPointCut() {

    }

    /**
     * 环绕切入
     */
    @Around("logPointCut()")
    public Object around (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null ;
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        try{
            // 执行方法
            result = proceedingJoinPoint.proceed();
            stopWatch.stop();
        } catch (Exception e){
            stopWatch.stop();
        } finally {
            // 保存日志
            LOGGER.info(" execute time: {} ms ", stopWatch.getTotalTimeMillis());
            DefineLogModel defineLogModel = buildLogParam (proceedingJoinPoint);
            defineLogModel.setResParam(JSONObject.toJSONString(result));
            defineLogService.saveLog(defineLogModel) ;
        }
        return result ;
    }

    private DefineLogModel buildLogParam (ProceedingJoinPoint point){

        DefineLogModel defineLogModel  = new DefineLogModel() ;

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method reqMethod = signature.getMethod();
        String className = point.getTarget().getClass().getName();
        Object[] reqParam = point.getArgs();

        LOGGER.info("请求方法:"+reqMethod.getName());
        LOGGER.info("请求类名:"+className);
        LOGGER.info("请求参数:"+ JSONObject.toJSONString(reqParam));
        // 获取方法上注解
        reqMethod.getAnnotation(DefinedLog.class).getClass();
        DefinedLog definedLog = reqMethod.getAnnotation(DefinedLog.class);

        // 构建参数
        String methodName = reqMethod.getName() ;
        Integer apiType = definedLog.apiType().getApiType();
        String apiTypeDesc = definedLog.apiType().getApiTypeDesc();
        String methodDesc = definedLog.methodDesc() ;
        Integer bizNature = definedLog.bizNature().getBizNature() ;
        Integer dataFlowType = definedLog.dataFlow().getDataFlowType();
        boolean isSaveReqParam = definedLog.isSaveReqParam();
        boolean isSaveResParam = definedLog.isSaveResParam();
        boolean isAsync = definedLog.isAsync() ;

        defineLogModel.setAppId(appId);
        defineLogModel.setClassName(className);
        defineLogModel.setMethodName(methodName);
        defineLogModel.setMethodDesc(methodDesc);
        defineLogModel.setApiType(apiType);
        defineLogModel.setApiTypeDesc(apiTypeDesc);
        defineLogModel.setBizNature(bizNature);
        defineLogModel.setDataFlowType(dataFlowType);
        defineLogModel.setSaveReqParam(isSaveReqParam);
        defineLogModel.setSaveResParam(isSaveResParam);
        defineLogModel.setAsync(isAsync);
        defineLogModel.setReqParam(JSONObject.toJSONString(reqParam));

        return defineLogModel ;
    }
}
