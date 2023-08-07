/**
 * 
 */
package com.varasofttech.controller.employee;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.varasofttech.business.Employee;
import com.varasofttech.service.employee.EmployeeService;

/**
 * @author Ranga Reddy
 * @date Jan 26, 2015
 * @version 1.0
 */

@Controller
public class EmployeeController {
	private Logger logger = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("createEmployee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        return new ModelAndView("employee");
    }
	
	@RequestMapping("editEmployee")
	public ModelAndView updateEmployee(@RequestParam long employeeId, @ModelAttribute Employee employee) {
		logger.info("Edit Employee");
		employee = employeeService.getEmployee(employeeId);
		return new ModelAndView("employee","employeeObject", employee);
	}
	
	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		logger.info("Save Employee "+employee);
		String message = "";
		if(employee.getId() == 0) {
			employeeService.createEmployee(employee);
			message = "Employee Created Successfully.";
		} else { 
			employeeService.updateEmployee(employee);
			message = "Employee Updated Successfully.";
		}
		return new ModelAndView("redirect:getAllEmployees", "message", message);
	}
	
	@RequestMapping("deleteEmployee")
	public ModelAndView deleteEmployee(@RequestParam long employeeId) {
		logger.info("Delete Employee");
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:getAllEmployees");
	}
	
	@RequestMapping(value = {"getAllEmployees", "/"})
	public ModelAndView getAllEmployees() {
		logger.info("Get All Employees");
		List<Employee> employeeList = employeeService.getAllEmployees();
		logger.info(employeeList);
		return new ModelAndView("employeeList", "employeeList", employeeList);
	}	
}