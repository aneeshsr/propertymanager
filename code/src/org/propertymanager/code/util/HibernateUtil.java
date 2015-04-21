package org.propertymanager.code.util;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.propertymanager.code.entity.Actor;


public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static{
		try {
		      // Create the SessionFactory from hibernate.cfg.xml
		      sessionFactory = new Configuration().configure().buildSessionFactory();
		    } catch (Throwable ex) {
		      // Make sure you log the exception, as it might be swallowed
		      System.err.println("Initial SessionFactory creation failed." + ex);
		      throw new ExceptionInInitializerError(ex);
		    }
		  
	}
	
	public static SessionFactory getSessionFactory(){
		
		return sessionFactory;
			
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List <Actor> list = session.createQuery("from Actor where actor_id<100").list();
			for (Actor actor : list){
			
				System.out.println("Id:"+actor.getActorId()+"Name:"+actor.getFirstName());			
			}
		
}
catch(Exception e){
	e.printStackTrace();
}

	}

}
