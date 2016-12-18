package com.spring.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.EmployeeDAO;
import com.spring.hibernate.pojo.Employee;
import com.spring.hibernate.service.EmployeeManager;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(Employee employee) {

		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {

		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(int employeeId) {

		employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public String updateEmployee(Employee employee) {

		return employeeDAO.updateEmployee(employee);
	}

}
