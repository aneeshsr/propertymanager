package org.propertymanager.code.database;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.propertymanager.code.entity.Actor;
import org.propertymanager.code.entity.Request;


public class HelloHibernate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try{
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List <Actor> list = session.createQuery("from Actor where actor_id<100").list();
		for (Actor actor : list){
			
			System.out.println("Id:"+actor.getActorId()+"Name:"+actor.getFirstName());			
		}
		Request exp = new Request(12L,"E",new Date(),"testing");
		Long id = (Long)session.save(exp);
		//session.
		System.out.println("Id:"+id);
		tx.commit();
		session.close();
		
}
catch(Exception e){
	e.printStackTrace();
}

	}

}
