package com.example.demo.repository;

import com.example.demo.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("宫保鸡丁");
        productInfo.setProductPrice(new BigDecimal(23.2));
        productInfo.setProductStock(12);
        productInfo.setProductDescription("good");
        productInfo.setProductIcon("xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

//    @Test
//    public ProductInfo findOne(){
//
//    }

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> productInfoList = repository.findByProductStatus(1);
        System.out.println(productInfoList.toString());
        Assert.assertNotEquals(1,productInfoList.size());


    }

}