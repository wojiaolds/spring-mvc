package lds.spring.mvc.config;

import lds.spring.mvc.inter.MyWebApplicationInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 零xml启动springmvc   方式一
 * @Author: lds
 * @Date: 2019/6/14 15:26
 */
public class ServletConfig implements MyWebApplicationInitializer {
	
	@Override
	public void doStart ( ServletContext context ) throws ServletException {
		
		System.out.println ("---->>> 零xml启动springmvc   方式一");
		AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
		XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
		xmlWebApplicationContext.setConfigLocations ("");
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext ();
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext ();
		
		
	}
	
}
