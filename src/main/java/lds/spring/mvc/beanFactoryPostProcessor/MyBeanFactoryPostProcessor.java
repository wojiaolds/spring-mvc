package lds.spring.mvc.beanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * @Author: lds
 * @Date: 2019/7/22 9:38
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	
	@Override
	public void postProcessBeanFactory (
		ConfigurableListableBeanFactory beanFactory ) throws BeansException {
		
		Iterator iterator = beanFactory.getBeanNamesIterator ();
		while (iterator.hasNext ()){
			System.out.println (iterator.next ());
		}
	}
}
