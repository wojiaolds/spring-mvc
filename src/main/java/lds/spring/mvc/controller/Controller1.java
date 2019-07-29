package lds.spring.mvc.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lds
 * @Date: 2019/7/19 17:21
 */
@Controller
public class Controller1 extends AbstractController {


	@Override
	protected ModelAndView handleRequestInternal (
		HttpServletRequest request, HttpServletResponse response ) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView ();
		modelAndView.addObject ("result","成功");
		modelAndView.setViewName ("result");
		return modelAndView;
	}




}
