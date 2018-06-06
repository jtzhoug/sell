package com.example.demo.service;


import com.example.demo.dataObject.SellerInfo;

//卖家端

public interface SellerService{

//    根据openid查询卖家端信息
    SellerInfo findSellerInfoByOpenid(String openid);
}
