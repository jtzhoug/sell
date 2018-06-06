package com.example.demo.service;

import com.example.demo.dataObject.CproductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CproductService {
    CproductInfo findOne(String productId);

    //  查询在架所有商品列表
    List<CproductInfo> findUpAll();

    Page<CproductInfo> findAll(Pageable pageable);

    CproductInfo save(CproductInfo cproductInfo);

    //    上架
    CproductInfo onSale(String productId);

    //    下架
    CproductInfo offSale(String productId);
}
