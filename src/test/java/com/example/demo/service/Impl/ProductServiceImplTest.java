package com.example.demo.service.Impl;

import com.example.demo.dataObject.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.service.Productservice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {
    @Autowired
    private Productservice productservice;

    @Test
    public void findOne() throws Exception {
        ProductInfo productInfo = productservice.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList= productservice.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() throws Exception {
        PageRequest request =  new PageRequest(0,2);
        Page<ProductInfo> productInfoList  = productservice.findAll(request);
        System.out.println(productInfoList.getTotalElements());

    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123460");
        productInfo.setProductName("红烧白斩鸡");
        productInfo.setProductPrice(new BigDecimal(35.2));
        productInfo.setProductStock(12);
        productInfo.setProductDescription("good");
        productInfo.setProductIcon("xxx.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);
        ProductInfo result = productservice.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
    public void onSale() throws Exception {

        ProductInfo result =  productservice.onSale("123458");
        Assert.assertEquals(ProductStatusEnum.UP,result.getProductStatusEnum());
    }

    @Test
    public void offSale() throws Exception {
        ProductInfo result =  productservice.offSale("123456");
        Assert.assertEquals(ProductStatusEnum.DOWN,result.getProductStatusEnum());
    }

}