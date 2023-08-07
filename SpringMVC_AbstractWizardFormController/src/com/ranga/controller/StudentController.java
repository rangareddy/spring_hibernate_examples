/**
 * 
 */
package com.ranga.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
/**
 * AbstractWizardFormControllerExample.java
 * @author ranga
 * Apr 12, 2014
 */
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.ranga.dto.Student;

public class StudentController extends AbstractWizardFormController {
	public StudentController() {
		System.out.println("StudentController()");
	}
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {		
		return new Student();
	}
	
	@Override
	protected ModelAndView processFinish(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException bindException)
			throws Exception {		
		Student student = (Student) command; // fetching Student form data from Command object
		System.out.println("Student Data: "+student);
		ModelAndView modelAndView = new ModelAndView("result","student", student);		
		return modelAndView;
	}
		
	@Override
	protected ModelAndView processCancel(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException bindException)
			throws Exception {		
		return new ModelAndView("index");
	}
}