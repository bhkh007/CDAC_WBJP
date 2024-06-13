package com.maven.EmployeeCrud;



import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.maven.EmployeeCrud.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        
        Session session = sf.openSession();
        
        Transaction txn = session.beginTransaction();
        
        String hql = "FROM Employee";
        Query<Employee> query = session.createQuery(hql);
        List<Employee> data = query.list();
        Iterator<Employee> itr = data.iterator();
        while(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        txn.commit();
        txn.begin();
    }
}
