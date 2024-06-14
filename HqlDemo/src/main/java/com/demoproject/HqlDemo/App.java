package com.demoproject.HqlDemo;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaDelete;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);

		Session session = cfg.buildSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		/*
		 * int id = 4;
		 * 
		 * String hql5 = "SELECT E.name, E.phone from Employee E WHERE E.id = :emp_id";
		 * Query query = session.createQuery(hql5); query.setParameter("emp_id", id);
		 * 
		 * String hql = "SELECT E.name, E.phone from Employee E"; String hql4 =
		 * "SELECT E.name, E.phone from Employee E WHERE E.id" + id; String hql1 =
		 * "SELECT E.name, E. phone from Employee E WHERE E.salary>4000"; String hql2 =
		 * "SELECT E.name, E. phone from Employee E ORDER BY E.salary"; List results =
		 * session.createQuery(hql).list(); Iterator itr = results.iterator();
		 * while(itr.hasNext()){ Object rs[] = (Object[])itr.next();
		 * System.out.println(rs[0] +" " +rs[1]); }
		 */

		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.gt("salary", 4000f));
		List result = cr.list();
		Iterator itr1 = result.iterator();
		while(itr1.hasNext()) {
			System.out.println(itr1.next());
		}

		/*HQL queries are preferrd more than Criteria 
		 * as Criteria methods are complicated to implement*/
	}
}
