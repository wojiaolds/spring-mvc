package lds.spring.mvc.config;

import lds.spring.mvc.beanFactoryPostProcessor.MyBeanFactoryPostProcessor;
import lds.spring.mvc.beanPostProcessor.MyBeanPostProcessor;
import lds.spring.mvc.controller.Controller1;
import lds.spring.mvc.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lds on 2019/1/25.
 */
//SpringMVC只扫描Controller；子容器   ,web容器 //useDefaultFilters=false 禁用默认的过滤规则； //web容器
@ComponentScan ( value = "lds.spring.mvc", includeFilters = {
	@ComponentScan.Filter ( type = FilterType.ANNOTATION, classes = {
		Controller.class } ) }, useDefaultFilters = false )
/**
 * 开启 MVC 支持，它会从 WebMvcConfigurationSupport 导入 Spring MVC 的配置，
 * 会在处理请求时加入注解的支持（比如 @RequestMapping，@ExceptionHandler等注解）。
 * 相当于<!--  <mvc:annotation-driven />
 */
@EnableWebMvc
@Configuration


public class WebConfig implements WebMvcConfigurer {
	//For advanced mode, you can remove @EnableWebMvc and extend directly
	// from DelegatingWebMvcConfiguration instead of implementing WebMvcConfigurer
	//DelegatingWebMvcConfiguration
	// 文档地址 ： https://docs.spring.io/spring/docs/5.0.2.RELEASE/spring-framework-reference/web.html#mvc-config-customize
	// 将SpringMVC处理不了的请求交给tomcat；静态资源 就可以访问

	@Autowired
	private Controller1 controller1;
	@Override
	public void configureDefaultServletHandling ( DefaultServletHandlerConfigurer configurer ) {
		
		configurer.enable ();//相当于xml文件配置<mvc:default-servlet-handler/>
	}
	//视图解析器
//	@Override
//	public void configureViewResolvers (
//		ViewResolverRegistry registry ) {
//		// TODO Auto-generated method stub
//		// 默认所有的页面都从 /WEB-INF/ xxx .jsp
//		//registry.jsp ();
//		registry.jsp ("/WEB-INF/jsp/", ".jsp");
//	}
	@Bean
	public ViewResolver getViewResolver() {
		
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver ();
		resolver.setCache(false);
		resolver.setContentType ("text/html;charset=UTF-8");
		//        resolver.setPrefix("");
		resolver.setSuffix(".jsp");
		
		
		return resolver;
		
	}
	
	@Bean
	public FreeMarkerConfigurer getFreemarkerConfig() {
		
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer ();
		
		freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/jsp/");
		
		ClassPathResource classPathResource = new ClassPathResource ("/META-INF/config/freemarker.properties");
		freeMarkerConfigurer.setConfigLocation (classPathResource);
		//freeMarkerConfigurer.setFreemarkerSettings(FreeMarkerProperties.properties);
		return freeMarkerConfigurer;
		
	}
	//注册拦截器
	@Override
	public void addInterceptors (
		InterceptorRegistry registry ) {
		//  /** 任意存路径
		registry.addInterceptor (new MyInterceptor ()).addPathPatterns ("/**");
	}
	
	/**
	
	 * 可以用@value("${template_update_delay}")注解获取
	 * @return
	 */
//	@Bean
//	public PropertyPlaceholderConfigurer createPropertyPlaceholderConfigurer(){
//		PropertyPlaceholderConfigurer propertyPlaceholderConfigurer
//			= new PropertyPlaceholderConfigurer ();
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

	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
		SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
		simpleUrlHandlerMapping.setOrder(0);
		Map<String,Object> map = new HashMap<>();
		map.put("/test/result.tran", controller1);
		map.put("test.tran", controller1);
		simpleUrlHandlerMapping.setUrlMap(map);
		return simpleUrlHandlerMapping;
	}

//	@Bean
//	public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter(){
//		return new SimpleControllerHandlerAdapter();
//	}

	/**
	 * BeanFactoryPostProcessor是在其他bean实例化前就实例化了的
	 * 不加static  MyBeanFactoryPostProcessor的实例化依赖于WebConfig
	 * 所以实例化MyBeanFactoryPostProcessor的时候，就要先实例化WebConfig，
	 * 此时controller1还没有被实例化，这个属性无法注入，后续实例化SimpleUrlHandlerMapping的时候就会出错
	 * @return
	 */
	@Bean
	public static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor(){
		return new MyBeanFactoryPostProcessor();
	}

	@Bean
	public MyBeanPostProcessor myBeanPostProcessor(){
		return new MyBeanPostProcessor();
	}
	
}
