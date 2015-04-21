package org.propertymanager.code.entity;

import java.io.Serializable;

import net.sf.gilead.pojo.gwt.LightEntity;

public class Actor extends LightEntity implements Serializable{
	private Long actorId;
	private String firstName;
	private String lastName;
	
	
	public Actor() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Long getActorId() {
		return actorId;
	}
	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
