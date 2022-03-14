package com.defined.log.controller;

import com.defined.log.annotation.DefinedLog;
import com.defined.log.model.ApiTypeEnum;
import com.defined.log.model.BizNatureEnum;
import com.defined.log.model.DataFlowEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @GetMapping("/logApi")
    @DefinedLog(apiType=ApiTypeEnum.COMPOSITE,
                methodDesc="测试日志",
                bizNature= BizNatureEnum.DEFAULT,
                dataFlow= DataFlowEnum.DEFAULT)
    public String logApi (@RequestParam("param") String param){
        return "success-re" ;
    }

}
