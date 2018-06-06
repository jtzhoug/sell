package com.example.demo.repository;

import com.example.demo.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "12321";
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1235");
        orderMaster.setBuyerName("mike");
        orderMaster.setBuyerPhone("17878787888");
        orderMaster.setBuyerAddress("火焰山");
        // orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(30));

        OrderMaster result = repository.save(orderMaster);

        Assert.assertNotNull(result);



    }

    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest request = new PageRequest(1,1);

        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID,request);
            Assert.assertNotEquals(0,result.getTotalElements());
        System.out.println(result.getTotalElements());



    }

}