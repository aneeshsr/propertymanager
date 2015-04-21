package org.propertymanager.code.client;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class MaintenanceRequestRow extends Widget implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6911772577214149957L;
		
	public Label getPropertyLabel() {
		return propertyTypeLabel;
	}
	public void setPropertyIdLabel(Label propertyIdLabel) {
		this.propertyTypeLabel = propertyIdLabel;
	}
	public Label getRequestTypeLabel() {
		return requestTypeLabel;
	}
	public void setRequestTypeLabel(Label requestTypeLabel) {
		this.requestTypeLabel = requestTypeLabel;
	}
	public Label getDateLabel() {
		return dateLabel;
	}
	public void setDateLabel(Label dateLabel) {
		this.dateLabel = dateLabel;
	}
	public Label getDescriptionLabel() {
		return descriptionLabel;
	}
	public void setDescriptionLabel(Label descriptionLabel) {
		this.descriptionLabel = descriptionLabel;
	}
	private Label propertyTypeLabel = new Label("Property Id:");
	private TextBox propertyId = new TextBox();
	public static final int PROPERTY_ID = 0;
	private TextBox requestType = new TextBox();
	public static final int REQ_TYPE_COLUMN = 3;
	private Label requestTypeLabel= new Label("Request Type:");
	private DateBox date = new DateBox();
	public static final int DATE_COLUMN = 1;
	private Label dateLabel= new Label("Date:");
	private TextBox description = new TextBox();
	public static final int DESC_COLUMN = 2;
	private Label descriptionLabel= new Label("Description:");
	
	public MaintenanceRequestRow(TextBox requestId, TextBox propertyId, TextBox requestType,
			DateBox date, TextBox description) {
		super();
		
		this.propertyId = propertyId;
		this.requestType = requestType;
		this.date = date;
		this.description = description;
	}
	public MaintenanceRequestRow(Double propertyId, String requestType,
			Date date, String description) {
		super();
		
		this.propertyId.setText(""+propertyId);
		this.requestType.setText(requestType);
		this.date.setValue(date);
		this.description.setText(description);
	}
	
	
	public MaintenanceRequestRow() {
		// TODO Auto-generated constructor stub
	}
	public TextBox getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(TextBox propertyId) {
		this.propertyId = propertyId;
	}
	public TextBox getRequestType() {
		return requestType;
	}
	public void setRequestType(TextBox requestType) {
		this.requestType = requestType;
	}
	public DateBox getDate() {
		return date;
	}
	public void setDate(DateBox date) {
		this.date = date;
	}
	public TextBox getDescription() {
		return description;
	}
	public void setDescription(TextBox description) {
		this.description = description;
	}
	
	
}
