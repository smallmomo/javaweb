package com.cmback.xncoding.mapper;

import com.cmback.xncoding.domain.User;
import com.github.abel533.mapper.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper extends Mapper<User> {

    /**
     * 登录验证
     *
     * @param name     用户名
     * @param password 密码
     * @return 对应userName的User对象，如果不存在，返回null。
     */
    public User checkLogin(@Param("name") String name, @Param("password") String password);
}
