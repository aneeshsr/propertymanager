package org.propertymanager.code.client;

import java.util.List;

import org.propertymanager.code.entity.Request;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PropertyManagerServiceAsync {
	void getResults(String objectRequired, AsyncCallback<List<Request>> callback);
	void saveResults(List<Request> requests, AsyncCallback<Long> callback);
	
}
