package com.stackroute.springmvc.employee.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.stackroute.springmvc.employee.model.Employee;


public class EmployeeRepository {
	
	private List<Employee> empList;

	public EmployeeRepository() {		
		this.empList = new ArrayList<>();
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	
	public boolean saveEmployee(Employee employee) {
		
		this.empList.add(employee);
		return true;
	}
	
	
	
	
	

}
