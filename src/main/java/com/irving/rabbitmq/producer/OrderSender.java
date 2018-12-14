package com.irving.rabbitmq.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irving.rabbitmq.entity.Order;
import org.json.JSONObject;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Development IDE: IntelliJ IDEA
 * Author: irving
 * Project Name: rabbitmqProject2
 * Date: 2018-12-02
 */

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void send(Order order) throws Exception {
        CorrelationData correlationData = new CorrelationData();

        correlationData.setId(order.getMessageId());
        rabbitTemplate.convertAndSend("order-exchange", //交换机exchange(在控制台创建的交换机名)
                "order.abcd",   //routingKey(在控制台绑定交换机exchange
                // 和队列queue的时候， 建立的路由规则{order.*匹配一条;order.#匹配任意})
        new JSONObject(order),  //消息体内容
                correlationData);   //消息唯一ID
    }
}
