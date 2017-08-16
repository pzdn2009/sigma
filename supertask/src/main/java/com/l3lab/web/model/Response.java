package com.l3lab.web.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.var;

/**
 * Summary:
 * User: zhenpeng
 * Date: 2017-08-16
 * Time: 14:55
 * <p>
 * Desc: {描述}
 */
@Data
@ApiModel(value = "Http 響應")
public class Response<T> {
    @ApiModelProperty(value = "代碼，0表示成功")
    private int code;

    @ApiModelProperty(value = "消息")
    private String message;

    @ApiModelProperty(value = "數據體")
    private T data;

    public static <T> Response<T> success(T data){
        var response = new Response<T>();
        response.setCode(0);
        response.setData(data);
        response.setMessage("");

        return response;
    }

    public static <T> Response<T> create(T data,int code, String message){
        var response = new Response<T>();
        response.setCode(code);
        response.setData(data);
        response.setMessage(message);
        return response;
    }
}
