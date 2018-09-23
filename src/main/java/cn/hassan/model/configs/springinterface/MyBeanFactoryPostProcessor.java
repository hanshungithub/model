package cn.hassan.model.configs.springinterface;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 9/23/2018 9:38 PM
 * Description: Spring允许在Bean创建之前，读取Bean的元属性，并根据自己的需求对元属性进行改变，比如将Bean的scope从singleton改变为prototype
 */
@Component
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition userController = beanFactory.getBeanDefinition("userController");
        MutablePropertyValues propertyValues = userController.getPropertyValues();
        log.error("userController scope --- > {}", userController.getScope());
        userController.setScope("singleton");
        log.error("scope after --- > {}", userController.getScope());
        log.error("beanProperty --- > {}",propertyValues);
    }
}
