package com.cmback.xncoding.controllers;

import com.cmback.xncoding.domain.User;
import com.cmback.xncoding.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;

    /**
     * 首页
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        logger.info("index() GET....");
        ModelAndView result = new ModelAndView();
        result.setViewName("template/index");
        result.addObject("ctx", request.getContextPath());
        return result;
    }

}