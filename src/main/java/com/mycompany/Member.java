package com.mycompany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name="MemberType")
public class Member {

	private String id;
	private String username;
	private String email;
	@XmlElement
	public String getId() {
		return id;
	}
	@XmlElement
	public String getUsername() {
		return username;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
