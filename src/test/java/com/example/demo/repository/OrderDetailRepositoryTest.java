package com.example.demo.repository;

import com.example.demo.dataObject.OrderDetail;
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
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail =  new OrderDetail();
        orderDetail.setDetailId("124");
        orderDetail.setProductName("红烧狮子头");
        orderDetail.setOrderId("1234");
        orderDetail.setProductPrice(new BigDecimal(15));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductId("123456");
        orderDetail.setProductIcon("xxx.jpg");

        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByOrderId() throws Exception {

        List<OrderDetail> orderDetailList = repository.findByOrderId("1234");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}