package com.example.demo.repository;

import com.example.demo.dataObject.SellerInfo;
import com.example.demo.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerInfoRepositoryTest {


    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellInfo = new SellerInfo();
        sellInfo.setSellerId(KeyUtil.genUniqueKey());
        sellInfo.setUsername("admin");
        sellInfo.setPassword("admin");
        sellInfo.setOpenid("110110");
        SellerInfo result = repository.save(sellInfo);
        Assert.assertNotNull(sellInfo);
    }

    @Test
    public void findbyOpenid() throws Exception {
        SellerInfo result = repository.findByOpenid("110110");
        Assert.assertEquals("admin",result.getUsername());


    }

}