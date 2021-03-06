package com.l3lab.web.model.requeset;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 13:07
 * <p>
 * Desc: {描述}
 */
@Data
@ApiModel(description = "創建任務Dto")
public class CreateTaskRequestDto {
    @ApiModelProperty(value = "標題")
    @NotBlank
    private String title;

    @ApiModelProperty(value = "細節")
    @NotBlank
    private String detail;

    @ApiModelProperty(value = "標籤，逗號分隔")
    private String tags;

    @ApiModelProperty(value = "創建人")
    private String createUser;
}
