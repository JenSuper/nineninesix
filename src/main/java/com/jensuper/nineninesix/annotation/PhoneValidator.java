package com.jensuper.nineninesix.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @author jichao
 * @version V1.0
 * @description: 自定义手机号约束注解关联验证器
 * @date 2020/01/21
 */
public class PhoneValidator implements ConstraintValidator<Phone,String> {

    /**
     * 自定义校验逻辑
     * @param value
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 手机号校验规则:以158开头
        String regex = "^158\\d{8}";
        // 空值处理
        String phone = Optional.ofNullable(value).orElse("");
        return Pattern.compile(regex).matcher(phone).matches();
    }
}
