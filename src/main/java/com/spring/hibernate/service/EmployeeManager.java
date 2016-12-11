package com.spring.hibernate.service;

import java.util.List;

import com.spring.hibernate.pojo.Employee;

public interface EmployeeManager {

	public void addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployee(Integer employeeId);
}
