package com.mycompany.client;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.mycompany.Contact;
import com.mycompany.ContactList;

public class ContactRestfulClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mycompany/client/contactclient.xml");
			String uri = "http://localhost:8080/springwebapp/rest/contact/xmllist";

			RestTemplate restTemplate = (RestTemplate) ctx.getBean("restTemplate");

			ContactList result = restTemplate.getForObject(uri,ContactList.class);
			if (result != null) {
				for (Contact c: result.getContacts()) {
					System.out.println("c.firstname = " + c.getFirstName());
				}
			} else {
				System.out.println("no result");
			}
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
