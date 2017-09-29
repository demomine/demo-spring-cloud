package com.lance.demo.springcloud.server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServerApplicationTest {
    @Value("${demo.name}")
    private String name;

    @Test
    public void configServer() throws Exception {
        Assert.assertEquals(name,"lance");
    }
}
