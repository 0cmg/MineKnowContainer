package com.rabbitmq.test.withspring;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wuhuachuan on 17/1/12.
 */
@RabbitListener(
        containerFactory = "simpleRabbitListenerContainerFactory",
        bindings = @QueueBinding(
                value = @Queue(value = "testDirectQueue1",durable = "true"),
                exchange = @Exchange(value = "testDirectExchange",type = ExchangeTypes.DIRECT),
                key = "key1")
)
@Component
public class Receiver {
    @RabbitHandler
    public void receiveMessage(Student student) {
        System.out.println("Received <" + student + ">");
    }
}
