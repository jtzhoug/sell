package com.example.demo.service.Impl;

import com.example.demo.dataObject.OrderDetail;
import com.example.demo.dto.OrderDTO;
import com.example.demo.enums.OrderStatusEnum;
import com.example.demo.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1527482901118844383";

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerPhone("17878787877");
        orderDTO.setBuyerAddress("七扇门");
        // orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerName("superpig");

//        购物车
        List<OrderDetail> orderDetailList =  new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(1);

        // OrderDetail orderDetail2 = new OrderDetail();
        // orderDetail2.setProductId("123457");
        // orderDetail2.setProductQuantity(2);
        //
        // orderDetailList.add(orderDetail2);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result) ;
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {

        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("[查询单个订单] result={}", result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());

    }

    @Test
    public void findList() throws Exception {
        PageRequest request = new PageRequest(2,2);

        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,request);

        Assert.assertNotEquals(0,orderDTOPage.getSize());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINIFSH.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void list() throws Exception {
        PageRequest request = new PageRequest(0,2);

        Page<OrderDTO> orderDTOPage = orderService.findList(request);

        Assert.assertNotEquals(0,orderDTOPage.getSize());
    }

}