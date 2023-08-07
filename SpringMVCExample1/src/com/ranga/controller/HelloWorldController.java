/**
 * 
 */
package com.ranga.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * HomeController.java
 * @author ranga
 * Mar 23, 2014
 */
public class HelloWorldController implements Controller {	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView("helloWorld","message","Hello World!");
		return mav;
	}
}