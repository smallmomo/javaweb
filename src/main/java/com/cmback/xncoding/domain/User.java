package com.cmback.xncoding.domain;

import javax.persistence.Table;

/**
 * 用户表
 *
 * @author XiongNeng
 * @version 1.0
 * @since 2015/11/12
 */
@Table(name = "t_user")
public class User extends BaseDomain {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 中文名
     */
    private String fullname;
    /**
     * 联系电话
     */
    private String mobile;
    /**
     * 角色 0:系统管理员 1:市公司管理员 2:终端维护员 3:终端店主
     */
    private Integer role;
    /**
     * 所属片区
     */
    private String area;

    /**
     * 获取 用户名.
     *
     * @return 用户名.
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置 用户名.
     *
     * @param username 用户名.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取 密码.
     *
     * @return 密码.
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 密码.
     *
     * @param password 密码.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取 中文名.
     *
     * @return 中文名.
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * 设置 中文名.
     *
     * @param fullname 中文名.
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * 获取 联系电话.
     *
     * @return 联系电话.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 联系电话.
     *
     * @param mobile 联系电话.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取 角色 0:系统管理员 1:市公司管理员 2:终端维护员 3:终端店主.
     *
     * @return 角色 0:系统管理员 1:市公司管理员 2:终端维护员 3:终端店主.
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置 角色 0:系统管理员 1:市公司管理员 2:终端维护员 3:终端店主.
     *
     * @param role 角色 0:系统管理员 1:市公司管理员 2:终端维护员 3:终端店主.
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 获取 所属片区.
     *
     * @return 所属片区.
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置 所属片区.
     *
     * @param area 所属片区.
     */
    public void setArea(String area) {
        this.area = area;
    }

}
