package com.stackroute.springmvc.employee.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.stackroute.springmvc.employee.model.Employee;
import com.stackroute.springmvc.employee.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	Employee employee = context.getBean("employee", Employee.class);
	EmployeeRepository empRepository = context.getBean("emprepository", EmployeeRepository.class);
	
	
	//@RequestMapping(value="hello", method= RequestMethod.GET)
	@GetMapping("/hello")
	public String getHomePage() {
		System.out.println("getHomePage");
		return "index";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		System.out.println("getHomePage");
		return "login";
	}
	
	@GetMapping("/signup")
	public String getSignupPage() {
		System.out.println("getHomePage");
		return "signup";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, ModelMap model) {
		
		System.out.println("Employee" + employee);
		empRepository.saveEmployee(employee);
		model.addAttribute("empList", empRepository.getEmpList());
		
		return "index";
	}
	
	
	
	

}
