
package com.cmback.xncoding.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * domain公共父类
 *
 * @author XiongNeng
 * @version 1.0
 * @since 2015/3/22
 */
public class BaseDomain implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date updatedTime;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * 获取 更新时间.
     *
     * @return 更新时间.
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置 创建时间.
     *
     * @param createdTime 创建时间.
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取 创建时间.
     *
     * @return 创建时间.
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置 更新时间.
     *
     * @param updatedTime 更新时间.
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 设置 主键ID.
     *
     * @param id 主键ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取 主键ID.
     *
     * @return 主键ID.
     */
    public Long getId() {
        return id;
    }
}

