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
 * Apr 12, 2014
 */

public class HomeController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		return new ModelAndView("page1");		
	}
}
