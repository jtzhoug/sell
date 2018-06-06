package com.example.demo.form;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {
//    @GeneratedValue
    private String productId;

    //    名字
    private String productName;

    //    单价
    private BigDecimal productPrice;
    //库存
    private Integer productStock;
    //描述
    private String productDescription;
    //图标
    private String productIcon;
    //状态 0正常 1下架
    //类目编号
    private Integer categoryType;


}
