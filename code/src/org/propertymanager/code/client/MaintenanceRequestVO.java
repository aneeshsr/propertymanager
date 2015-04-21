package org.propertymanager.code.client;
import java.io.Serializable;
import java.util.Date;


public class MaintenanceRequestVO implements Serializable{
	
	/**
	 * 
	 */
	
	public MaintenanceRequestVO(){
		
	}
	public MaintenanceRequestVO(Long propertyId, String requestType, Date date,
			String description) {
		super();
		this.propertyId = propertyId;
		this.requestType = requestType;
		this.date = date;
		this.description = description;
	}
	public MaintenanceRequestVO(Long requestID, Long propertyId, String requestType, Date date,
			String description) {
		super();
		this.requestId=requestID;
		this.propertyId = propertyId;
		this.requestType = requestType;
		this.date = date;
		this.description = description;
	}
	private Long requestId;
	private Long propertyId;
	private String requestType;
	private Date date;
	private String description;
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
