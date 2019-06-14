package lds.spring.mvc.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by lds on 2019/1/25.
 */
//Spring的容器不扫描controller;父容器
@ComponentScan (
	value = "lds.spring.mvc",excludeFilters = {
	@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = { Controller.class}),
	@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = { EnableWebMvc.class})
})
@Configuration
@PropertySource ({ "classpath:META-INF/config/lds.properties"})
public class RootConfig {
	
	/**
	 *  * 1.     @value是在所有bean创建成功后再执行
	 * 2.     @value注解只会在当前容器中查询数据
	 *子容器要用也需要单独配置这个bean
	 * 可以用@value("${template_update_delay}")注解获取
	 * @return
	 */
//	@Bean
//	public PropertyPlaceholderConfigurer createPropertyPlaceholderConfigurer(){
//		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer
//					= new PropertyPlaceholderConfigurer ();
//
//		System.out.println(this.getClass().getResource("").getPath());
//		System.out.println(this.getClass().getResource("/").getPath());
//		System.out.println(RootConfig.class.getClassLoader ().getResource("").getPath());
//		System.out.println(RootConfig.class.getClassLoader ().getResource("/").getPath());
//
//		Resource resource = new ClassPathResource ("/META-INF/config/lds.properties") ;
//		propertyPlaceholderConfigurer.setLocations (resource);
//		return propertyPlaceholderConfigurer;
//	}
	
}


