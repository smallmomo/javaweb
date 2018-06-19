package com.cmback.xncoding.services;

import com.cmback.xncoding.domain.User;
import com.cmback.xncoding.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    protected Logger _logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public String getpassword() {
        return "123456";
    }

    public User checkPassword(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return null;
        }
        return userMapper.checkLogin(username, password);
    }

}
