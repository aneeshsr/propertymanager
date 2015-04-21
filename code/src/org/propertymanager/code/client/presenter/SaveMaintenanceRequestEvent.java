package org.propertymanager.code.client.presenter;

import com.google.gwt.event.shared.GwtEvent;

public class SaveMaintenanceRequestEvent extends GwtEvent<SaveMaintenanceRequestEventHandler> {
	public static Type<SaveMaintenanceRequestEventHandler> TYPE = new Type<SaveMaintenanceRequestEventHandler>(); 

	@Override
	public Type<SaveMaintenanceRequestEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(SaveMaintenanceRequestEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onSaveRequest(this);
	}

}
