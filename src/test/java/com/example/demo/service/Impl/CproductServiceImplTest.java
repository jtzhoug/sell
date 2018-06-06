package com.example.demo.service.Impl;

import com.example.demo.dataObject.CproductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.service.CproductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
@SpringBootTest
@RunWith(SpringRunner.class)
public class CproductServiceImplTest {

    @Autowired
    private CproductService cproductService;
    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void save() throws Exception {

        CproductInfo cproductInfo = new CproductInfo();
        cproductInfo.setProductId("12346");
        cproductInfo.setProductName("短袖");
        cproductInfo.setProductPrice(new BigDecimal(12.3));
        cproductInfo.setProductDescription("saaadsa");
        cproductInfo.setProductIcon("xxx.jpg");
        cproductInfo.setCategoryType(1);
        CproductInfo result = cproductService.save(cproductInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findUpAll() throws Exception {
    }

    @Test
    public void onSale() throws Exception {
        CproductInfo result =  cproductService.onSale("12345");
        Assert.assertEquals(ProductStatusEnum.UP,result.getProductStatusEnum());
    }

    @Test
    public void offSale() throws Exception {
        CproductInfo result =  cproductService.offSale("12345");
        Assert.assertEquals(ProductStatusEnum.DOWN,result.getProductStatusEnum());
    }

}