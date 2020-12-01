package org.dkwork.javatemplate.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ApiModel(value = "统一返回对象")
public class ResultInfo<T> implements Serializable {

    @ApiModelProperty(value = "状态码", example = "200")
    private Integer code;
    @ApiModelProperty(value = "消息")
    private String message;
    @ApiModelProperty(value = "数据对象")
    private T result;
    @ApiModelProperty(value = "数量")
    private Long total;

    public ResultInfo(Status status) {
        super();
        this.code = status.code;
        this.message = status.message;
    }

    public ResultInfo(Status status, String message) {
        super();
        this.code = status.code;
        this.message = status.message + " 详细信息： " + message;
    }

    public ResultInfo(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResultInfo<T> result(T result) {
        this.result = result;
        return this;
    }

    public ResultInfo<T> result(Status status) {
        this.code = status.code;
        this.message = status.message;
        return this;
    }

    public ResultInfo<T> total(Long total) {
        this.total = total;
        return this;
    }


}
