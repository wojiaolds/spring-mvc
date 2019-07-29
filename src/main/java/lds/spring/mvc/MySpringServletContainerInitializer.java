//package lds.spring.mvc;
//
//import lds.spring.mvc.inter.MyWebApplicationInitializer;
//
//import javax.servlet.ServletContainerInitializer;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.HandlesTypes;
//import java.lang.reflect.Modifier;
//import java.util.Set;
//
///**
// * Created by lds on 2019/1/24.
// */
//@HandlesTypes ( MyWebApplicationInitializer.class )
//public class MySpringServletContainerInitializer implements ServletContainerInitializer {
//
//	@Override
//	public void onStartup ( Set <Class <?>> set, ServletContext servletContext )
//	throws ServletException {
//
//		if (set != null) {
//			for ( Class <?> webApplicationInitializerClass : set ) {
//				if (!webApplicationInitializerClass.isInterface () && !Modifier
//					.isAbstract (webApplicationInitializerClass.getModifiers ())
//				    && MyWebApplicationInitializer.class.isAssignableFrom (
//					webApplicationInitializerClass)) {
//					try {
//						( ( MyWebApplicationInitializer ) webApplicationInitializerClass
//							.newInstance () ).doStart (servletContext);
//					} catch ( Throwable ex ) {
//						throw new ServletException (
//							"Failed to instantiate webApplicationInitializer class",
//							ex);
//					}
//				}
//			}
//		}
//
//	}
//}
