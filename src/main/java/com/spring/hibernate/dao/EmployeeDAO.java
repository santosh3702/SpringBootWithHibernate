package com.spring.hibernate.dao;

import java.util.List;

import com.spring.hibernate.pojo.Employee;

public interface EmployeeDAO {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(int employeeId);
	
	public String updateEmployee(Employee employee);

}
