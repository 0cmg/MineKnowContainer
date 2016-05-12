package test.config;

import lombok.Data;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by wuhuachuan on 16/3/28.
 */
@EnableRabbit
@Configuration
@Data
public class RabbitMQConfig {

    @Bean(name = "myConnectionFactory")
    SimpleRabbitListenerContainerFactory createSimpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);

        return factory;
    }
}
