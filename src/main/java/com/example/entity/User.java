package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 蓝猫
 * @since 2024-07-29
 */
@Data
@Accessors(chain = true)
@TableName("user")
@Schema(name = "User", description = "")
public class User {

    @Schema(description = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "姓名")
    @TableField("name")
    private String name;

    @Schema(description = "年龄")
    @TableField("age")
    private Integer age;

    @Schema(description = "邮箱")
    @TableField("email")
    private String email;
}
