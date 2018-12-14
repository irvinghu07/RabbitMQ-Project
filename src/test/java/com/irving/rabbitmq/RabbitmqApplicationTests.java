package com.irving.rabbitmq;

import com.irving.rabbitmq.entity.Order;
import com.irving.rabbitmq.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSend() {
        Order order = new Order("2018120200000001",
                "Irving' s 2nd order",
                System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        try {
            orderSender.send(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
