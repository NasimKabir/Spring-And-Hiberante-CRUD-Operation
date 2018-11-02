package com.springweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springweb.model.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	private SessionFactory sessionfactory;

	public List<Employee> getAllList() {
		Session session = sessionfactory.getCurrentSession();
		Query<Employee> query = session.createQuery("from EmployeeInfo", Employee.class);
		List<Employee>employee=query.getResultList();
		return employee;
	}

	public void addEmployee(Employee employee) {
		Session session=sessionfactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	public Employee updateEmployee(int id) {
		Session session=sessionfactory.getCurrentSession();
		Employee employee=session.get(Employee.class,id);
		return employee;
	}

	public void delete(int id) {
		Session session=sessionfactory.getCurrentSession();
		Query query=session.createQuery("delete from EmployeeInfo where id=:id");
		query.setParameter("id",id);
		 query.executeUpdate();
	}
}
