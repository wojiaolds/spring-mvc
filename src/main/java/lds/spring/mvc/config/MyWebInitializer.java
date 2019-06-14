package lds.spring.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * 零xml启动springmvc   方式二
 * Created by lds on 2019/1/25.
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 定义拦截器 ContextLoaderListener 应用上下文中的 beans
	 * 加载其他 bean，通常是一些中间层和数据层的组件（比如数据库配置 bean 等）
	 * @return
	 */
	@Override
	protected Class <?>[] getRootConfigClasses () {
		
		return new Class<?>[]{ RootConfig.class};
	}

	/**
	 * 定义 DispatcherServlet 应用上下文中的 beans
	 * 加载包含 web 组件的 bean，比如 controllers，view resolvers 和 hanlder mappings。
	 * @return
	 */
	@Override
	protected Class <?>[] getServletConfigClasses () {

		return new Class<?>[]{ WebConfig.class};
	}

	/**
	 *
	 * @return
	 */
	@Override
	protected String[] getServletMappings () {

		return new String[]{"*.tran"};
	}
	
//	/**
//	 * 不需要 mapping，因为会自动 mapping 到 DispatcherServlet 上
//	 * @return
//	 */
//	@Override
//	protected Filter[] getServletFilters(){
//
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter ();
//		characterEncodingFilter.setEncoding ("UTF-8");
//		characterEncodingFilter.setForceEncoding (true);
//
//		return new Filter[] { characterEncodingFilter };
//	}
}
