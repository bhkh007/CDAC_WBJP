package com.maven.EmployeeCrud;


import java.util.Iterator;
import java.util.List;
/*import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;*/
import java.util.Scanner;

import com.maven.EmployeeCrud.daoimpl.EmployeeDAOImpl;
import com.maven.EmployeeCrud.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
        char continuationChoice;
        do {
        	System.out.println("1.Add Employee \n2.GetAll Employee \n3.Get By Id\n4.Remove Employee \n5.Exit");
            System.out.println("Enter choice");
            int choice = sc.nextInt();
            if(choice==1) {
            	Employee employee = new Employee();
            	System.out.println("Enter ID");
            	employee.setId(sc.nextInt());
            	System.out.println("Enter Name");
            	sc.nextLine();
            	employee.setName(sc.next());
            	System.out.println("Enter phone");
            	employee.setPhone(sc.next());
            	System.out.println("Enter salary");
            	employee.setSalary(sc.nextFloat());
            	int id = employeeDAOImpl.save(employee);
            	System.out.println("Id" + id);
            	
            }
            else  if(choice==2) {
            	List<Employee> employees = employeeDAOImpl.getAll();
            	if(employees==null) {
            		System.out.println("No employee found");
            	}
            	else {
            		Iterator<Employee> itr = employees.iterator();
            		while(itr.hasNext()) {
            			Employee employee = itr.next();
            			System.out.println(employee);
            		}
            	}
            }
            else if(choice ==3) {
            	System.out.println("Enter employee id to update");
            	int id = sc.nextInt();
            	Employee employee = employeeDAOImpl.getById(id);
            	if(employee!=null) {
            		System.out.println(employee);
            	}
            	else {
            		System.out.println("Employee with given id not found");
            	}
            }
            
            else if(choice == 4) {
            	System.out.println("Enter employee id to delete");
            	int id = sc.nextInt();
            	int result = employeeDAOImpl.remove(id);
            	if(result !=-1) {
            		System.out.println("Employee removed");
            	}
            	else {
            		System.out.println("Employee with given id not found");
            	}
            }
            
            System.out.println("Do you want to continue Y/N");
            continuationChoice = sc.next().charAt(0);
		} while (continuationChoice =='Y');
        
        
        
        
        
   
        
    }
}
