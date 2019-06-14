package lds.spring.mvc.inter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by lds on 2019/1/24.
 */
public interface MyWebApplicationInitializer {
	
	void doStart ( ServletContext context ) throws ServletException;
	
}
