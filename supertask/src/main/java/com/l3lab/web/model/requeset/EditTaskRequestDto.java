package com.l3lab.web.model.requeset;

import com.l3lab.domain.valueobject.TaskStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 15:12
 * <p>
 * Desc: {描述}
 */
@Data
@ApiModel(description = "修改任務Dto")
public class EditTaskRequestDto {

    @ApiModelProperty("任務Id")
    @NotNull
    @Min(1)
    private Long id;

    @ApiModelProperty(value = "標題")
    @NotBlank
    private String title;

    @ApiModelProperty(value = "細節")
    @NotBlank
    private String detail;

    @ApiModelProperty(value = "標籤，逗號分隔")
    private String tags;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "狀態")
    private TaskStatus status;
}