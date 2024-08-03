package com.example.entity.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class UserVo {

    @Schema(description = "主键ID")
    private Long id;

    @Schema(description = "姓名")
    @NotBlank(message = "姓名不能为空")
    private String name;

    @Schema(description = "年龄")
    @Range(min = 3, max = 150, message = "年龄需要大于3小于150")
    private Integer age;

    @Schema(description = "邮箱")
    @NotBlank
    @Email
    private String email;
}
