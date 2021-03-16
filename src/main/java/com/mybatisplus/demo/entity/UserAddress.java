package com.mybatisplus.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("user_Id")
    private Integer userId;

    /**
     * 住址
     */
    private String address;

    /**
     * 区县
     */
    private String district;


}
