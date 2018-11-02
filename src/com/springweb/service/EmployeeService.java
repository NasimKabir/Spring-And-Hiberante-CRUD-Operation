package com.springweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springweb.dao.EmployeeDao;
import com.springweb.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public List<Employee> getEmployeeList() {
		return employeeDao.getAllList();
	}

	@Transactional
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Transactional
	public Employee updateEmployee(int id) {
		return employeeDao.updateEmployee(id);
	}

	@Transactional
	public void delete(int id) {
		employeeDao.delete(id);

	}

}
