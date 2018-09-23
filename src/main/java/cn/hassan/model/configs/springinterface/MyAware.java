package cn.hassan.model.configs.springinterface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 9/23/2018 8:57 PM
 * Description:
 */
//@Component
@Slf4j
public class MyAware implements BeanNameAware, ApplicationContextAware, BeanFactoryAware {

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        log.error("beanfactory --- > {}",beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        log.error("myaware --- > {}", name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        log.error("applicationContext --- > {}",applicationContext);
    }
}
