package lds.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lds on 2019/1/24.
 */
@Controller
public class HelloController {
	
	@Value("${MSG}")
	private String msg;
	
	
	@RequestMapping ( "/index" )
	public String index () {
		
		return "index";
	}
	
	@RequestMapping ( "/hello" )
	public String hello ( ModelMap model ) {
		
		model.put ("msg",msg);
		model.addAttribute ("msg1", "hello! wojiaolds! welcome to this page.");
		return "hello";
	}
	
	@RequestMapping ( "/reject" )
	public String reject () {
		
		System.out.println ("sorry,you can't open this page");
		return "reject";
	}
	
}
