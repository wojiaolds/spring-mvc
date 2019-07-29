package lds.spring.mvc.beanPostProcessor;

import lds.spring.mvc.controller.Controller1;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lds
 * @Date: 2019/7/16 11:33
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private Controller1 controller1;

	@Override
	public Object postProcessBeforeInitialization ( Object bean, String beanName )
	throws BeansException {
//		if(StringUtils.equals(beanName,"viewControllerHandlerMapping")) {
//			System.out.println("---" + beanName + "----");
//			System.out.println(bean);
//			SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
//			simpleUrlHandlerMapping.setOrder(0);
//			Map<String,Object> map = new HashMap<>();
//			map.put("result.tran", controller1);
//			map.put("test.tran", controller1);
//			simpleUrlHandlerMapping.setUrlMap(map);
//			return simpleUrlHandlerMapping;
//		}
		return bean;

	}
	
	@Override
	public Object postProcessAfterInitialization ( Object bean, String beanName )
	throws BeansException {
		
		return bean;
	}
}
