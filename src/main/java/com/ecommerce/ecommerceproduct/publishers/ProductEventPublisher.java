package com.ecommerce.ecommerceproduct.publishers;

import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductEventDto;
import com.ecommerce.ecommerceproduct.api.mapper.dto.ProductResponse;
import com.ecommerce.ecommerceproduct.domain.model.Product;
import com.ecommerce.ecommerceproduct.enums.ActionType;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProductEventPublisher {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value(value = "${rabbitmq.broker.exchange}")
    private String exchangeProductEvent;

    @Value(value = "${rabbitmq.broker.routing")
    private String routingProductEvent;

    public void publisherProductEvent(ProductEventDto productEventDto, ActionType actionType){
        productEventDto.setActionType(actionType.toString());
        rabbitTemplate.convertAndSend(exchangeProductEvent, routingProductEvent, productEventDto);
        log.debug("Message send to broker.");
    }
}
