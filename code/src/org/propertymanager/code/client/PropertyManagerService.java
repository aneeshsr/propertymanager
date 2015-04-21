package org.propertymanager.code.client;

import java.util.List;

import org.propertymanager.code.entity.Request;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PropertyManagerService")
public interface PropertyManagerService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PropertyManagerServiceAsync instance;
		public static PropertyManagerServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PropertyManagerService.class);
			}
			return instance;
		}
	}
	
	List<Request> getResults(String objectRequired) throws IllegalArgumentException;
	Long saveResults(List<Request> requests) throws IllegalArgumentException;
	
}
