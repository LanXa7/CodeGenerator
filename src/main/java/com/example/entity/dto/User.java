package com.example.entity.dto;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author 蓝猫
 * @since 2024-08-03
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

    @Schema(description = "操作人")
    @TableField(value = "operator_name", fill = FieldFill.INSERT_UPDATE)
    private String operatorName;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField("deleted")
    @TableLogic
    private Byte deleted;
}
