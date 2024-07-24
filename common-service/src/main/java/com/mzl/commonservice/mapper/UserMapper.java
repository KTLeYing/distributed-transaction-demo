package com.mzl.commonservice.mapper;

import com.mzl.commonservice.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper 接口
 *
 * @author mzl
 * @since 2024-07-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
