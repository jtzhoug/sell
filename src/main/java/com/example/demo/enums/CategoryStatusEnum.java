package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum CategoryStatusEnum implements CodeEnum{

    FOOD(0,"餐品"),
    CLOTH(1,"衣物")
    ;
    private Integer code;
    private String message;

    CategoryStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
