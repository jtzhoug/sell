package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1() {

        String name = "first";
        String password = "1234556";
        String day = "1831";

        log.debug("debug...");
        log.info("name: "+ name + "password: "+password );
        log.info("name: {}, password: {}",name,password);
        log.info("name: {}, password: {}, day: {}",name,password,day);
        log.error("error");
    }
}