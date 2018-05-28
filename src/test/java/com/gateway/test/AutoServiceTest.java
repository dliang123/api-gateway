package com.gateway.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class AutoServiceTest {

    @Test
    public void test() {
        Long time = new Date().getTime();
        System.out.println(time);
        String uid = UUID.randomUUID().toString();
        System.out.println(uid);
    }
}
