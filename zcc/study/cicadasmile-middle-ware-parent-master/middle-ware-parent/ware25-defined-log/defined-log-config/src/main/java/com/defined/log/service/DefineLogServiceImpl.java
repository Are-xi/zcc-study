package com.defined.log.service;

import com.alibaba.fastjson.JSONObject;
import com.defined.log.entity.DefineLogModel;
import com.defined.log.mapper.DefineLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DefineLogServiceImpl implements DefineLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefineLogServiceImpl.class);

    @Resource
    private DefineLogMapper defineLogMapper ;

    public void saveLog(DefineLogModel defineLogModel) {
        String logInfo = JSONObject.toJSONString(defineLogModel) ;
        LOGGER.info(logInfo);
        defineLogMapper.insert(defineLogModel) ;
    }
}
