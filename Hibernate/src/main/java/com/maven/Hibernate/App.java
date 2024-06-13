package com.maven.Hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;




public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        

        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Product.class).addAnnotatedClass(Employee.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();
        
        
		/*
		 * Product p = new Product(); p.setId(103); p.setName("AC"); p.setPrice(10000);
		 * p.setQuantity(3);
		 */
        // session.save(p);
        
		/*
		 * Employee emp = new Employee(); emp.setId(11); emp.setName("John");
		 * emp.setSalary(5692); emp.setPhone("654646"); session.save(emp);
		 */
        
        Employee emp = session.get(Employee.class, 1);
        System.out.println(emp);
        
        
       
        txn.commit();
        
        
    }
}
