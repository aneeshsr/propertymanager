package org.propertymanager.code.entity;
import java.io.Serializable;
import java.util.Date;

import net.sf.gilead.pojo.gwt.LightEntity;


public class Request extends LightEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2843393349738464779L;
	/**
	 * 
	 */
	
	public Request(){
		
	}
	public Request(Long propertyId, String requestType, Date date,
			String description) {
		super();
		this.propertyId = propertyId;
		this.requestType = requestType;
		this.date = date;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", propertyId=" + propertyId
				+ ", requestType=" + requestType + ", date=" + date
				+ ", description=" + description + "]";
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
	public void setAmount(Long propertyId) {
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
