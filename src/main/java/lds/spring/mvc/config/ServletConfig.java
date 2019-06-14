package lds.spring.mvc.config;

import lds.spring.mvc.inter.MyWebApplicationInitializer;

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
	}
}
