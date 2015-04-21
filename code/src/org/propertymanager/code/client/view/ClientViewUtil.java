package org.propertymanager.code.client.view;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class ClientViewUtil {
	
	public static FlexTable createHeaders(int column, FlexTable table,String... headerNames){
		Label ref =null;
		for(String headerName: headerNames){
		ref = new Label(headerName);
		ref.addStyleName("exp-TableColumnHeader");
		table.setWidget(0, column++, ref);
		}
		return table;
	}

}
