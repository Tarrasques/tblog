package com.tblog.rabbitmq.sevice;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
public class OrderService {

    @Autowired
    private RabbitTemplate template;

    /**
     *  模拟用户下单
     * @param userId
     * @param productId
     * @param mun
     */
    public void makeOrder(String userId,String productId,int mun){
        //1根据商品id查询库存是否充足
        //2保存订单
        String orderId = UUID.randomUUID().toString().replace("-","");
        log.info("订单生成成功："+orderId);
        //3通过订单来完成消息的分发
        //参数：交换机 路由key/queue队列名称  消息内容
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";
        template.convertAndSend(exchangeName,routingKey,orderId);
    }
}
