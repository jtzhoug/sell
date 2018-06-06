package com.example.demo.service.Impl;

import com.example.demo.dataObject.CproductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.repository.CproductInfoRepository;
import com.example.demo.service.CproductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CproductServiceImpl implements CproductService {
    @Autowired
    private CproductInfoRepository repository;

    @Override
    public CproductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public Page<CproductInfo> findAll(Pageable pageable) { return repository.findAll(pageable); }

    @Override
    public CproductInfo save(CproductInfo cproductInfo) {
        return repository.save(cproductInfo);
    }

    @Override
    public List<CproductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    //上架
    @Override
    public CproductInfo onSale(String productId) {

        CproductInfo cproductInfo = repository.findOne(productId);
        if (cproductInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (cproductInfo.getProductStatus().equals(ProductStatusEnum.UP)){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        cproductInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        repository.save(cproductInfo);
        return repository.save(cproductInfo);
    }

    //下架
    @Override
    public CproductInfo offSale(String productId) {
        CproductInfo cproductInfo = repository.findOne(productId);
        if (cproductInfo == null){
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        if (cproductInfo.getProductStatus().equals(ProductStatusEnum.DOWN)){
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        cproductInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        return repository.save(cproductInfo);

    }
}
