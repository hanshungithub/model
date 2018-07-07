package cn.hassan.model.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/7 13:30
 * Description:
 */
@Component
public class MessageProducer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public <T> void send(T t, String queue) {
        ActiveMQQueue destination = new ActiveMQQueue(queue);
        jmsMessagingTemplate.convertAndSend(destination, t);
    }
}
