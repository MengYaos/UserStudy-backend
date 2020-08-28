package com.firsts.survey.mapper;

import com.firsts.survey.domain.dto.ResultInfoDto;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultInfoMapper {
    int insertResult(ResultInfoDto resultInfoDto);
}
