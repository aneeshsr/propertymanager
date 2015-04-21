package org.propertymanager.code.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PropertyManager implements EntryPoint {
	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get();
		//Home home = new Home();
		//rootPanel.add(home.asWidget());
		// createFoodPlanner(rootPanel);
		PropertyManagerServiceAsync rpcService = GWT.create(PropertyManagerService.class);
		HandlerManager eventBus = new HandlerManager(null);
		AppController appViewer = new AppController(rpcService,eventBus);
		appViewer.go(rootPanel);
	}


}
