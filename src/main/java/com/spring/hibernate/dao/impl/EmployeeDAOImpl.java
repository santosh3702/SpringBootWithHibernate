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

	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
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
		return session.createCriteria("from Employee").list();
		// return this.sessionFactory.getCurrentSession().createQuery("from
		// Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {

		Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}
	}

	private Session getSession() {

		Session session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		return session;
	}
}
