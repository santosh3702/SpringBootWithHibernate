package com.spring.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.pojo.Employee;
import com.spring.hibernate.service.EmployeeManager;

@RestController
public class MyController {

	@Autowired
	private EmployeeManager employeeManager;

	@RequestMapping("/addEmployee")
	public String addEmployee() {

		Employee employee = new Employee();
		employee.setEmail("aviral@live.com");
		// employee.setEmpId(1);
		employee.setFirstname("Aviral");
		employee.setLastname("Mittal");
		employee.setTelephone("8527701990");
		employeeManager.addEmployee(employee);
		return "Inserted Successfully";
	}
	
	@RequestMapping("/deleteEmployee")
	public void deleteEmployee(){
		
		employeeManager.deleteEmployee(2);
	}
	
	@RequestMapping("/getEmployee")
	public List<Employee> getEmployee(){
		
		return employeeManager.getAllEmployees();
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(){
		
		Employee employee = new Employee();
		employee.setEmpId(5);
		employee.setEmail("aviral@gmail.com");
		return employeeManager.updateEmployee(employee);
	}
}
