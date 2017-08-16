package com.l3lab.web.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 12:18
 * <p>
 * Desc: {描述}
 */
@ApiModel(description = "任務返回詳細")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {

    @ApiModelProperty(value = "Id")
    private Long id;

    @ApiModelProperty(value = "標題")
    private String title;

    @ApiModelProperty(value = "詳細")
    private String detail;

    @ApiModelProperty(value = "狀態")
    private String status;
}
