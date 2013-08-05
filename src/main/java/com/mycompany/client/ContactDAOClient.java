package com.mycompany.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.dao.ContactDAO;

public class ContactDAOClient {
	ContactDAO contactDAO;

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}

	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("contactcontext.xml");
			ContactDAOClient contactDAOClient = (ContactDAOClient) ctx.getBean("contactDAOClient");

			ContactDAO contactDAO = contactDAOClient.getContactDAO();

			System.out.println(contactDAO.getContacts());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
