package com.spring.hibernate.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.hibernate.pojo.Address;
import com.spring.hibernate.pojo.Employee;
import com.spring.hibernate.service.EmployeeManager;

@RestController
@RequestMapping("/employee")
public class MyController {

	@Autowired
	private EmployeeManager employeeManager;

	@RequestMapping(method = { RequestMethod.POST }, value ="/addEmployee")
	public String addEmployee() {

		Employee employee = new Employee();
		employee.setEmail("aviral@live.com");
		employee.setFirstname("Aviral");
		employee.setLastname("Mittal");
		employee.setTelephone("8527701990");
		Address address1 = new Address();
        address1.setStreet("First Street");
        address1.setCity("First City");
        address1.setState("First State");
        address1.setPincode("First Pin");
        
        Address address2 = new Address();
        address2.setStreet("Second Street");
        address2.setCity("Second City");
        address2.setState("Second State");
        address2.setPincode("Second Pin");
		employee.setAddress(address1);
		employeeManager.addEmployee(employee);
		return "Inserted Successfully";
	}
	
	@RequestMapping(method = { RequestMethod.DELETE }, value ="/deleteEmployee")
	public void deleteEmployee(){
		
		employeeManager.deleteEmployee(2);
	}
	
	@RequestMapping(method = { RequestMethod.GET }, value ="/getEmployee")
	public List<Employee> getEmployee(String id){
		
		return employeeManager.getAllEmployees();
	}
	
	@RequestMapping(method = { RequestMethod.POST }, value ="/updateEmployee")
	public String updateEmployee(){
		
		Employee employee = new Employee();
		employee.setEmpId(5);
		employee.setEmail("aviral@gmail.com");
		return employeeManager.updateEmployee(employee);
	}
	
	@RequestMapping(method = { RequestMethod.GET }, value ="/getEmployeeById")
	public @ResponseBody Employee getEmployeeById(@RequestParam int id){
		
		return employeeManager.getAllEmployeesById(id);
	}
}
