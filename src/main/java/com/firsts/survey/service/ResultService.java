package com.firsts.survey.service;

import com.firsts.survey.constant.GoalVerifyRegex;
import com.firsts.survey.domain.dto.ResultInfoDto;

import com.firsts.survey.exception.RCException;
import com.firsts.survey.mapper.ResultInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class ResultService {

    @Autowired
    ResultInfoMapper resultInfoMapper;

    /**
     * 新增一条调查结果
     * @Param resultInfo
     * @return int
     */

    public int addResult(ResultInfoDto resultInfoDto) throws Exception {

        resultInfoDto.setCreateTime(new Date());
        List<String> contentIntegrity = Arrays.asList(resultInfoDto.getContentIntegrity().split(","));
        List<String> stylizationLevel = Arrays.asList(resultInfoDto.getStylizationLevel().split(","));
        List<String> overallQuality = Arrays.asList(resultInfoDto.getOverallQuality().split(","));
        List<String> renderingSequence = Arrays.asList(resultInfoDto.getRenderingSequence().split(","));

//        Integer children = 11;
//        if (resultInfoDto.equals( 2))
//            children = 5;

        if (!checkGoal(contentIntegrity) || !checkGoal(stylizationLevel) || !checkGoal(overallQuality))
            throw new RCException(GoalVerifyRegex.GOAL_MSG);
        Map<Integer,Integer> flagMap = new HashMap<>();

//        for (int i=0;i<renderingSequence.size();i+=children){
//            for (int j=1;j<=children;j++)
//                flagMap.put(j,0);
//
//            for (int j=0;j<children;j++){
//                Integer temp = Integer.valueOf(renderingSequence.get(i+j));
//                if (temp.compareTo(0) < 0 || temp.compareTo(children) > 0){
//                    throw new RCException(GoalVerifyRegex.SEQUENCE_INDEX_MSG);
//                } else{
//                    if (flagMap.get(temp).equals(1))
//                        throw new RCException(GoalVerifyRegex.SEQUENCE_MSG);
//                    else
//                        flagMap.put(temp,1);
//                }
//            }
//        }

        return resultInfoMapper.insertResult(resultInfoDto);
    }

    /**
     * 检验分数处于[1，10]
     */
    public boolean checkGoal(List<String> goals){
        for (String goal:goals){
            Integer temp = Integer.valueOf(goal);
            if (temp.compareTo(1) < 0 || temp.compareTo(10) > 0)
                return false;
        }

        return true;
    }
}
