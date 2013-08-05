package com.mycompany.client;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.Contact;
import com.mycompany.SimpleContactApp;



public class ContactWebserviceClient {

	private SimpleContactApp service;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mycompany/client/contactclient.xml");
			ContactWebserviceClient conapp = (ContactWebserviceClient) ctx.getBean("client");
			Contact ch = conapp.getService().getContact("contact1");
			System.out.println((ch == null) ? "contact is null add some test data" : "contact firstname " + ch.getFirstName());
			System.out.println(conapp.getService().sayHello());
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}

	public SimpleContactApp getService() {
		return service;
	}

	public void setService(SimpleContactApp service) {
		this.service = service;
	}

}
