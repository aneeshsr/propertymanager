package org.propertymanager.code.client;

import org.propertymanager.code.client.presenter.AddMaintenanceRequestPresenter;
import org.propertymanager.code.client.presenter.Presenter;
import org.propertymanager.code.client.presenter.SaveMaintenanceRequestEvent;
import org.propertymanager.code.client.presenter.SaveMaintenanceRequestEventHandler;
import org.propertymanager.code.client.presenter.ViewMaintenanceRequestPresenter;
import org.propertymanager.code.client.view.AddMaintenanceRequestView;
import org.propertymanager.code.client.view.ViewMaintenanceRequestView;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String>{
	private HasWidgets container;
	private final PropertyManagerServiceAsync rpcService;
	private final HandlerManager eventBus;
	public AppController(PropertyManagerServiceAsync rpcService, HandlerManager eventBus) {
		// TODO Auto-generated constructor stub
		this.eventBus =  eventBus;
		this.rpcService = rpcService;
		bind();
	}

	private void bind() {
		// TODO Auto-generated method stub
		History.addValueChangeHandler(this);
		
		eventBus.addHandler(SaveMaintenanceRequestEvent.TYPE, new SaveMaintenanceRequestEventHandler() {
			
			@Override
			public void onSaveRequest(SaveMaintenanceRequestEvent event) {
				// TODO Auto-generated method stub
				doSaveRequest();
			}
		});
	}

	private void doSaveRequest() {
		// TODO Auto-generated method stub
		History.newItem("viewrequests");
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		// TODO Auto-generated method stub
		String token = event.getValue();
		if(token !=null){
			Presenter presenter = null;
			if("newrequest".equals(token)){
				presenter = new AddMaintenanceRequestPresenter(rpcService, eventBus, new AddMaintenanceRequestView());
			}else if("viewrequests".equals(token)){
				presenter = new ViewMaintenanceRequestPresenter(rpcService, eventBus, new ViewMaintenanceRequestView());
			}
			if(presenter!=null){
				presenter.go(container);
			}
		}
		
		
		
	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub
		this.container =  container;
		if("".equals(History.getToken())){
			History.newItem("newrequest");
		}else{
			History.fireCurrentHistoryState();
		}
	}

}
