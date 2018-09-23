package cn.hassan.model.configs.springinterface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 9/23/2018 8:37 PM
 * Description: 如果使用需要加@Component
 */
//@Component
@Slf4j
public class MyBeanPostProcess implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.error("before 初始化 --- >" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.error("after 初始化 --- >" + beanName);
        return bean;
    }
}
