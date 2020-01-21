package com.jensuper.nineninesix.controller;

import com.jensuper.nineninesix.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author jichao
 * @version V1.0
 * @description:
 * @date 2020/01/21
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @PostMapping("/add")
    public String test(@RequestBody @Valid User user,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        System.out.println(user.toString());
        return "user";
    }
}
