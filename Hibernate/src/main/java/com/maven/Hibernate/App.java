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
        cfg.configure().addAnnotatedClass(Product.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction txn = session.beginTransaction();
        
        
        Product p = new Product();
        p.setId(101);
        p.setName("Cooler");
        p.setPrice(6000);
        p.setQuantity(5);
        
        session.save(p);
        txn.commit();
        
        
    }
}
