package com.evildoer.exam.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evildoer.exam.common.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户管理 Mapper 接口
 * </p>
 *
 * @author evildoer
 * @datetime 2021-01-26
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
