package test.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhuachuan on 16/3/28.
 */

@RestController
public class Producer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/test/{abc}",method = RequestMethod.GET)
    public String test(@PathVariable(value = "abc") String abc){

        rabbitTemplate.convertAndSend("spring-boot-exchange","spring-boot", abc + " from RabbitMQ!");
        return  "abc";
    }
}
