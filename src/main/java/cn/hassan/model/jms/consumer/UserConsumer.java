package cn.hassan.model.jms.consumer;

import cn.hassan.model.jms.enums.DestinationEnums;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/7 13:31
 * Description:
 */
@Component
public class UserConsumer {

    @JmsListener(destination = "send_user_destination")
    public void test(String msg) {
        System.out.println("消息来了 --->" + msg);
    }
}
