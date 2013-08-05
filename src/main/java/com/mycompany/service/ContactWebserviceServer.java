package com.mycompany.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.Contact;
import com.mycompany.ContactApp;
import com.mycompany.SimpleContactApp;

/**
 * run this as standalone using jdk 1.6
 * @author ming
 *
 */
public class ContactWebserviceServer {
	List<Contact> contactList;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mycompany/service/contactserver.xml");
			SimpleContactApp ca = (SimpleContactApp) ctx.getBean("simplecontactApp");
			ContactWebserviceServer cs = (ContactWebserviceServer)ctx.getBean("contactWebserviceServer");
			Contact c = new Contact();
			c.setFirstName("firstName");
			c.setLastName("lastName");
			c.setEmail("email");
			c.setContactId(1);
			ca.insertAcontact(c);
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
