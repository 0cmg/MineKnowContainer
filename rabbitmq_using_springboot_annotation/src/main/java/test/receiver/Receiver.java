package test.receiver;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wuhuachuan on 16/3/28.
 */

@RabbitListener(
        containerFactory = "myConnectionFactory",
        bindings = @QueueBinding(
                value = @Queue(value = "testDirectQueue1",durable = "true"),
                exchange = @Exchange(value = "testDirectExchange",type = ExchangeTypes.DIRECT),
                key = "key1")
)
@Component
public class Receiver {
    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
