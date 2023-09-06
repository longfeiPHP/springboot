package com.hailong.www.mapper;

import com.hailong.www.model.School;
import org.apache.ibatis.annotations.Param;

/**
 * mybatis xml
 */
public interface SchoolMapper {
    public School getSchoolById(@Param("id") Long id);
}
