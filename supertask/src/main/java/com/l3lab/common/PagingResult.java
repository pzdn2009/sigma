package com.l3lab.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 16:07
 * <p>
 * Desc: {描述}
 */
@Data
@ApiModel
public class PagingResult<T> {
    @ApiModelProperty(value = "總數")
    private long total;
    @ApiModelProperty(value = "總的頁數")
    private Integer totalPage;
    @ApiModelProperty(value = "當前數據體")
    private T data;
}