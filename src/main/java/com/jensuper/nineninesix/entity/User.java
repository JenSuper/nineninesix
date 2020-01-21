package com.jensuper.nineninesix.entity;

import com.jensuper.nineninesix.annotation.Phone;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author jichao
 * @version V1.0
 * @description:
 * @date 2020/01/21
 */
@Data
public class User {

    @NotNull(message = "id不能为空")
    private Integer id;
    private String name;
    @Phone(message = "手机号格式错误")
    private String phone;
}
