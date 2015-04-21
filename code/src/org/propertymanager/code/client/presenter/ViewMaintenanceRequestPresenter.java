package org.propertymanager.code.client.presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.propertymanager.code.client.PropertyManagerServiceAsync;
import org.propertymanager.code.client.util.PropertyManagerConstants;
import org.propertymanager.code.entity.Request;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ViewMaintenanceRequestPresenter implements Presenter{
	
	private static Logger logger = Logger.getLogger("ParentLogger.Child");
	
	public interface Display {
	
		Widget asWidget();
		
		void displayRequests(List<Map<String,String>> requests);
		
		}
	
	private final Display display;
	private final HandlerManager eventBus;
	private final PropertyManagerServiceAsync rpcService;

	public ViewMaintenanceRequestPresenter(PropertyManagerServiceAsync rpcServiceAsync,
			HandlerManager eventBus, Display view) {
		this.rpcService = rpcServiceAsync;
		this.eventBus = eventBus;
		this.display = view;
		rpcService.getResults("", new AsyncCallback<List<Request>>() {
			
			@Override
			public void onSuccess(List<Request> result) {
				// TODO Auto-generated method stub
				List<Map<String,String>> requestMap = createRequestMapFromVOList(result);
				display.displayRequests(requestMap);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				System.out.println("Failure in view request get results");
				caught.printStackTrace();
			}
		});
	}

	
	
	protected List<Map<String, String>> createRequestMapFromVOList(
			List<Request> requestVOList) {
		List<Map<String, String>> requests = new ArrayList<Map<String,String>>();
		logger.info("requestVOList : "+requestVOList);
		System.out.println("requestVOList sop: "+requestVOList.toString());
		if (requestVOList != null && requestVOList.size() > 0) {
				requests = new ArrayList<Map<String,String>>(requestVOList.size());
				Map<String,String> eachRequest = null;
				for (Request row : requestVOList) {
					eachRequest = new HashMap<String,String>();
					eachRequest.put(PropertyManagerConstants.PROPERTYID, row.getPropertyId().toString());
					eachRequest.put(PropertyManagerConstants.REQUEST_ID, row.getRequestId().toString());
					eachRequest.put(PropertyManagerConstants.DESCRIPTION, row.getDescription());
					eachRequest.put(PropertyManagerConstants.DATE, row.getDate().toString());
					requests.add(eachRequest);
				}
			}

			return requests;
		
	}



	@Override
	public void go(HasWidgets container) {
		// ODO Auto-generated method stub\		
		bind();
		container.clear();
		container.add(display.asWidget());
	}

	public void bind() {
		// TODO Auto-generated method stub
		
		
	}

}
