package test.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by wuhuachuan on 16/3/28.
 */

@RabbitListener(containerFactory = "myConnectionFactory",queues = "spring-boot")
@Component
public class Receiver {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
