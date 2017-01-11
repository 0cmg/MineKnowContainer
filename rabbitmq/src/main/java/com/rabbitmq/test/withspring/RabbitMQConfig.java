package com.rabbitmq.test.withspring;

/**
 * Created by wuhuachuan on 17/1/12.
 */

import lombok.Data;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wuhuachuan on 16/3/28.
 */
@EnableRabbit
@Configuration
@Data
public class RabbitMQConfig {

    @Bean(name = "studentMessageConverter")
    public MessageConverter StudentMessageConverter() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setDefaultType(Student.class);

        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        messageConverter.setClassMapper(classMapper);

        return messageConverter;
    }

    @Bean(name = "simpleRabbitListenerContainerFactory")
    SimpleRabbitListenerContainerFactory createSimpleRabbitListenerContainerFactory(
            @Qualifier(value = "studentMessageConverter") MessageConverter studentMessageConverter,
            ConnectionFactory connectionFactory) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(studentMessageConverter);

        return factory;
    }

    @Bean(name = "rabbitTemplate")
    RabbitTemplate rabbitTemplate(
            @Qualifier(value = "studentMessageConverter") MessageConverter studentMessageConverter,
            ConnectionFactory connectionFactory) {

        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(studentMessageConverter);

        return template;
    }
}
