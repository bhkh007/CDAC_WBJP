package com.maven.EmployeeCrud.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.maven.EmployeeCrud.dao.EmployeeDAO;
import com.maven.EmployeeCrud.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	
	private SessionFactory sf;
	private Session session;
	private Configuration cfg;
	
	public EmployeeDAOImpl() {

		cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		sf = cfg.buildSessionFactory();
	}
	
	@Override
	public int save(Employee employee) {
		session = sf.openSession();
		Transaction txn = null;
		Integer id = null;
		try {
			txn = session.beginTransaction();
			id = (Integer)session.save(employee);
			txn.commit();
			
		} catch (Exception e) {
			if(txn!=null){
				txn.rollback();
			}
			e.printStackTrace();
		}
		finally {
			
			session.close();
		}
		
		return id;
	}

	@Override
	public List<Employee> getAll() {
		session = sf.openSession();
		Transaction txn = null;
		List<Employee>  employeesList = new ArrayList<Employee>();
		try {
			txn = session.beginTransaction();
			employeesList =session.createQuery("FROM Employee").list();
			txn.commit();
			
			
		} catch (Exception e) {
			if(txn!=null){
				txn.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
			
		}
		return employeesList;
	}

	@Override
	public Employee getById(int id) {
		session = sf.openSession();
		Transaction txn = null;
		Employee emp = null;
		try {
			txn = session.beginTransaction();
			emp =session.get(Employee.class, id);
			txn.commit();
			
			
		} catch (Exception e) {
			if(txn!=null){
				txn.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
			
		}
		return emp;
	}

	@Override
	public int remove(int id) {
		session = sf.openSession();
		Transaction txn = null;
		Employee emp = null;
		int result = -1;
		try {
			txn = session.beginTransaction();
			emp = session.get(Employee.class, id);
			
			if(emp!=null) {
				session.delete(emp);
				
				txn.commit();
				result = 1;	
			}
		} catch (Exception e) {
			if(txn!=null){
				txn.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
			
		}
		return result;
	}

	@Override
	public int update(int id, String name, String phone, float salary) {
		session = sf.openSession();
		Transaction txn = null;
		Employee emp = null;
		int result = -1;
		try {
			txn = session.beginTransaction();
			emp = session.get(Employee.class, id);
			
			if(emp!=null) {
				emp.setName(name);
				emp.setPhone(phone);
				emp.setSalary(salary);
				
				session.update(emp);
				
				txn.commit();
				result = 1;	
			}
		} catch (Exception e) {
			if(txn!=null){
				txn.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
			
		}
		return result;
	}

}
