package com.maven.EmployeeCrud.dao;

import java.util.List;

import com.maven.EmployeeCrud.model.Employee;

public interface EmployeeDAO {

	int save(Employee employee);
	List<Employee> getAll();
	Employee getById(int id);
	int remove(int id);
	int update(int id, String name, String phone, float salary);
	
}
