package org.propertymanager.code.server;

import java.util.ArrayList;
import java.util.List;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.core.hibernate.HibernateUtil;
import net.sf.gilead.core.store.stateless.StatelessProxyStore;
import net.sf.gilead.gwt.PersistentRemoteService;

import org.hibernate.Session;
import org.propertymanager.code.client.PropertyManagerService;
import org.propertymanager.code.client.MaintenanceRequestVO;
import org.propertymanager.code.database.DBConnection;
import org.propertymanager.code.entity.Request;

import com.google.gwt.core.client.GWT;

public class PropertyManagerServiceImpl extends PersistentRemoteService implements PropertyManagerService {
	
	private HibernateUtil gileadHibernateUtil = new HibernateUtil();
	
	public PropertyManagerServiceImpl(){
		gileadHibernateUtil.setSessionFactory(org.propertymanager.code.util.HibernateUtil.getSessionFactory());
		PersistentBeanManager persistentBeanManager = new PersistentBeanManager();
		persistentBeanManager.setPersistenceUtil(gileadHibernateUtil);
		persistentBeanManager.setProxyStore(new StatelessProxyStore());
		setBeanManager(persistentBeanManager);
		
	}
	@Override
	public List<Request> getResults(String objectRequired)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("inside getResults");
		List<MaintenanceRequestVO> requestVOs = new ArrayList<MaintenanceRequestVO>();
		Session session = gileadHibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List <Request> list = new ArrayList<Request>(session.createQuery("from Request").list());
		
		System.out.println("list of requests Aneesh:"+list);
		session.getTransaction().commit();
		/*MaintenanceRequestVO requestVO =null;
		for (Request request : list){
			System.out.println("Id:"+request.getRequestId()+"Name:"+request.getAmount());
			requestVO = createRequestVOFromEntity(request);
			if(requestVO!=null){
				requestVOs.add(requestVO);
			}
						
		}*/
		
		return list;
	}
	
	

	@Override
	public Long saveResults(List<Request> requests)
			throws IllegalArgumentException {
		
		// TODO Auto-generated method stub
		Long id = 0L;
	//	Request expData = null;
		DBConnection db = new DBConnection();
		db.createSessionFactory();
			
		for(Request request: requests){
		//Request requestEntity = createRequestEntityFromVO(request);
		id = db.saveObject(request);
		System.out.println("saved:"+id);
		GWT.log("GWT log saved:"+id);
		}
		
				
		return id;
	}

	private Request createRequestEntityFromVO(MaintenanceRequestVO requestvo) {
		// TODO Auto-generated method stub
		Request request = new Request(requestvo.getPropertyId(),
				requestvo.getRequestType(), requestvo.getDate(),
				requestvo.getDescription());
		return request;
	}
	
	private MaintenanceRequestVO createRequestVOFromEntity(Request request) {
		// TODO Auto-generated method stub
		MaintenanceRequestVO requestVO = new MaintenanceRequestVO(request.getRequestId(),request.getPropertyId(),
				request.getRequestType(), request.getDate(),
				request.getDescription());
		return requestVO;
	}
	
	
}
