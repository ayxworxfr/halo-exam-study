package com.evildoer.exam.model.form;

import com.evildoer.exam.common.domain.BasePage;
import lombok.Data;

import javax.validation.constraints.Size;

//import io.swagger.annotations.ApiModelProperty;

/**
 * @author 安羽兮
 * @ClassName UserQuery
 * @description: TODO
 * @datetime: 2020/7/1510:23
 * @Version 1.0
 **/
@Data
public class UserQuery extends BasePage {

    @Size(max = 25, message = "用户名的字符长度不能超过 {max}")
    //@ApiModelProperty(value = "用户名", required = false, example = "admin")
    private String username;
}
