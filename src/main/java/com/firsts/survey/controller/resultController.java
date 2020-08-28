package com.firsts.survey.controller;

import com.firsts.survey.constant.R;
import com.firsts.survey.constant.ResultControllerResultMsg;
import com.firsts.survey.domain.dto.ResultInfoDto;
import com.firsts.survey.exception.RCException;
import com.firsts.survey.service.ResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class resultController {

    @Autowired
    ResultService resultService;

    /**
     * 保存结果
     */
    @PostMapping("/save")
    @ResponseBody
    public R<String> saveResult(@RequestBody ResultInfoDto resultInfoDto){
        try{
            return resultService.addResult(resultInfoDto)>0 ? R.success("success",ResultControllerResultMsg.RESULT_INSERT_SUCCESS) : R.failure(ResultControllerResultMsg.RESULT_INSERT_ERROR);
        }catch (Exception e){
            e.printStackTrace();
//            return R.failure("失败");
            return R.failure(e.getMessage());
        }
    }
}
