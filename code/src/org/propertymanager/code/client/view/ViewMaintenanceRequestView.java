package org.propertymanager.code.client.view;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.propertymanager.code.client.presenter.ViewMaintenanceRequestPresenter;
import org.propertymanager.code.client.util.PropertyManagerConstants;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class ViewMaintenanceRequestView extends Composite implements ViewMaintenanceRequestPresenter.Display{
	 private static Logger logger = Logger.getLogger("ParentLogger.Child");

	private FlexTable requestTable;
	private final FlexTable contentTable;
	  
	@Override
	public Widget asWidget(){
		return this;
	}
	
	public ViewMaintenanceRequestView(){
		DecoratorPanel contentTableDecorator = new DecoratorPanel();
	    initWidget(contentTableDecorator);
	    contentTableDecorator.setWidth("100%");
	    contentTableDecorator.setWidth("18em");
	    
		contentTable = new FlexTable();
		contentTable.setCellPadding(0);
		contentTable.setCellSpacing(1);
		
		requestTable = new FlexTable();
		requestTable.setCellPadding(0);
		requestTable.setWidth("100%");
		requestTable.setCellSpacing(0);
		requestTable.getColumnFormatter().setWidth(0, "15px");
		
		requestTable = ClientViewUtil.createHeaders(0, requestTable, "Sl.No","PropertyId","Description","Date");
		
		//contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
	    
	    contentTable.setWidget(0, 0, requestTable);
	   // contentTable.setWidget(1, 0, hPanel);
		contentTableDecorator.add(contentTable);
	}
	
	@Override
	public void displayRequests(List<Map<String, String>> requests) {
		
		Map<String,String> requestMap = null;
		int length =requests.size();
		int numRows = 1;
		int column = 0;
		if(length>0){
			for(int i=0;i<length;i++){
				column=0;
				requestMap = requests.get(i);
				requestTable.setWidget(numRows, column++, new Label((String)requestMap.get(PropertyManagerConstants.REQUEST_ID)));
				requestTable.setWidget(numRows, column++, new Label((String)requestMap.get(PropertyManagerConstants.PROPERTYID)));
				requestTable.setWidget(numRows, column++, new Label((String)requestMap.get(PropertyManagerConstants.DATE)));
				requestTable.setWidget(numRows, column++, new Label((String)requestMap.get(PropertyManagerConstants.DESCRIPTION)));
				numRows++;
			}
		}
		

		
	
	}

	

	
}
