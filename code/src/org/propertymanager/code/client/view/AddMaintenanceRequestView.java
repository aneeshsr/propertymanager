package org.propertymanager.code.client.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.propertymanager.code.client.MaintenanceRequestRow;
import org.propertymanager.code.client.presenter.AddMaintenanceRequestPresenter;
import org.propertymanager.code.client.util.PropertyManagerConstants;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class AddMaintenanceRequestView extends Composite implements AddMaintenanceRequestPresenter.Display{
	 private static Logger logger = Logger.getLogger("ParentLogger.Child");

	private final Button addButton;
	private final Button saveButton;
	private FlexTable requestTable;
	private final FlexTable contentTable;
	
	
	  
	@Override
	public HasClickHandlers getAddButton() {
		// TODO Auto-generated method stub
		return addButton;
	}

	@Override
	public HasClickHandlers getSaveButton() {
		// TODO Auto-generated method stub
		return saveButton;
	}

	@Override
	public HasClickHandlers getRequests() {
		// TODO Auto-generated method stub
		return requestTable;
	}
	
	@Override
	public Widget asWidget(){
		return this;
	}
	
	public AddMaintenanceRequestView(){
		
		 DecoratorPanel contentTableDecorator = new DecoratorPanel();
	    initWidget(contentTableDecorator);
	    contentTableDecorator.setWidth("100%");
	    contentTableDecorator.setWidth("18em");
	    
		contentTable = new FlexTable();
		contentTable.setCellPadding(0);
		contentTable.setCellSpacing(1);
		
		requestTable = new FlexTable();
		requestTable.setCellPadding(2);
		requestTable.setWidth("100%");
		requestTable.setCellSpacing(2);
		
		requestTable.getColumnFormatter().setWidth(0, "15px");
		requestTable.getColumnFormatter().setWidth(1, "15px");
		requestTable.getColumnFormatter().setWidth(2, "15px");
		//requestTable.getColumnFormatter().addStyleName(0, "exp-TableColumnHeader");
		requestTable = ClientViewUtil.createHeaders(0, requestTable, "Property Id","Date","Description");
		
		// Create the menu
	    //
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setBorderWidth(0);
	    hPanel.setSpacing(0);
	    hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
	    addButton = new Button("Add");
	    hPanel.add(addButton);
	    saveButton = new Button("Save");
	    hPanel.add(saveButton);
	    //contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
	    
	    contentTable.setWidget(0, 0, requestTable);
	    contentTable.setWidget(1, 0, hPanel);
		contentTableDecorator.add(contentTable);
	}
	
	@Override
	public void addRow() {
		MaintenanceRequestRow requestRow = new MaintenanceRequestRow();
		int numRows = requestTable.getRowCount();
		int column = 0;
		Widget widget = requestRow.getPropertyId();
		String styleName = ".exp-TableCellWithBorder";
		requestTable.setWidget(numRows, column++, widget);
		requestTable.getFlexCellFormatter().addStyleName(numRows, column, styleName);
		widget = requestRow.getDate();
		requestTable.setWidget(numRows, column++, widget);
		widget = requestRow.getDescription();
		requestTable.setWidget(numRows, column++, widget);
		
		// flexTable.getFlexCellFormatter().setRowSpan(0, 1, numRows + 1);
	}

	@Override
	public List<Map<String, String>> saveRows() {
		// TODO Auto-generated method stub
		List<Map<String, String>> requests =null;
		Map<String,String> requestMap = null;
		int length =requestTable.getRowCount();
		if(length>0){
			requests = new ArrayList<Map<String,String>>(requestTable.getRowCount());
			
			for(int i=1;i<length;i++){
				requestMap = new HashMap<String,String>();
				requestMap.put(PropertyManagerConstants.PROPERTYID, ((TextBox)requestTable.getWidget(i, MaintenanceRequestRow.PROPERTY_ID)).getText());
				logger.log(Level.INFO, "Date valuess:"+((DateBox)requestTable.getWidget(i, MaintenanceRequestRow.DATE_COLUMN)).getValue().toString());
				requestMap.put(PropertyManagerConstants.DATE, ((DateBox)requestTable.getWidget(i, MaintenanceRequestRow.DATE_COLUMN)).getValue().toString());
				requestMap.put(PropertyManagerConstants.DESCRIPTION, ((TextBox)requestTable.getWidget(i, MaintenanceRequestRow.DESC_COLUMN)).getText());
				requests.add(requestMap);
			}
		}
		
		//workign
		
		return requests;
	}
	
	

	
}
