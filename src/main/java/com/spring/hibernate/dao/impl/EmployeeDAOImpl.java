package com.spring.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.spring.hibernate.dao.EmployeeDAO;
import com.spring.hibernate.pojo.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private Transaction transaction;

	private Session session;

	@Autowired
	private SessionFactory sessionFactory;

	public EmployeeDAOImpl() {
		super();
	}

	@Override
	public void addEmployee(Employee employee) {

		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		System.out.println(transaction);
		session.save(employee);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Employee> getAllEmployees() {

		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}

		return (List<Employee>) session.createCriteria(Employee.class).list();
	}

	@Override
	public String updateEmployee(Employee employee) {

		String response = null;
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		if (employee.getEmpId() > 0) {
			Employee emp = (Employee) session.get(Employee.class, employee.getEmpId());
			if (!StringUtils.isEmpty(emp)) {
				if (!StringUtils.isEmpty(employee.getFirstname())) {
					emp.setFirstname(employee.getFirstname());
				}
				if (!StringUtils.isEmpty(employee.getLastname())) {
					emp.setLastname(employee.getLastname());
				}
				if (!StringUtils.isEmpty(employee.getEmail())) {
					emp.setEmail(employee.getEmail());
				}
				if (!StringUtils.isEmpty(employee.getTelephone())) {
					emp.setTelephone(employee.getTelephone());
				}
				try {
					session.update(emp);
					transaction.commit();
					response = "Successfully Updated";
				} catch (Exception e) {
					response = "Exception generated...";
					e.printStackTrace();
				} finally {
					session.close();
				}
			}
		} else {
			response = "No data exist for the given id";
		}
		return response;
	}

	@Override
	public void deleteEmployee(int employeeId) {

		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		Employee emp = (Employee) session.get(Employee.class, employeeId);
		System.out.println(emp);
		session.delete(emp);
		transaction.commit();
		session.close();
	}

	private Session getSession() {

		Session session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		return session;
	}
}
