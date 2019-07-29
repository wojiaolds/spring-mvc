package lds.spring.mvc.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
//        BeanDefinition beanDefinition;
//        try {
//
//            beanDefinition = beanFactory.getBeanDefinition("simpleUrlHandlerMapping");
//        }catch (Exception e){
//            beanDefinition = null;
//        }
//        if(beanDefinition != null){
//            System.out.println(beanDefinition);
//        }
//        System.out.println(beanDefinition);

    }
}
