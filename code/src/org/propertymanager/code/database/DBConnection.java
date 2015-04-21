package org.propertymanager.code.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBConnection {

	private static DBConnection dbConnection = null;
	Session session = null;
	SessionFactory sessionFactory = null;
	
	public static DBConnection  getDBConnection(){
		if(dbConnection!=null){
			dbConnection = new DBConnection();
			dbConnection.createSessionFactory();
			
		}
		return dbConnection;
	}

	/**
	 * @param args
	 */
	public void createSessionFactory() {
		// TODO Auto-generated method stub
		try {

			sessionFactory= new Configuration().configure()
					.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Long saveObject(Object obj) {
		session = sessionFactory.openSession();		
		Transaction tx = null;
		Long id =0L;
		try{
		tx = session.beginTransaction();
		id = (Long) session.save(obj);
		// session.
		System.out.println("Save Object Id:" + id);
		tx.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
		closeSession();
		}
		return id;

	}
	
	public void closeSession(){
		//tx.commit();
		session.close();
	}

	

}
