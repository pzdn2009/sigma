package com.l3lab.web.model.requeset;

import com.l3lab.domain.valueobject.TaskStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 15:51
 * <p>
 * Desc: {描述}
 */
@Data
@ApiModel(value = "查詢請求Dto")
public class QueryTaskRequestDto {

    @ApiModelProperty("分頁索引")
    @Min(0)
    private Integer page = 1;

    @ApiModelProperty("分頁大小")
    @Min(1)
    private Integer size = 10;

    @ApiModelProperty(value = "標題")
    private String title;

    @ApiModelProperty(value = "創建人")
    private String createUser;

    @ApiModelProperty(value = "修改人")
    private String updateUser;

    @ApiModelProperty(value = "狀態")
    private TaskStatus taskStatus;

    @ApiModelProperty(value = "標籤")
    private String tags;

    @ApiModelProperty("排序")
    private Integer asc;
}
