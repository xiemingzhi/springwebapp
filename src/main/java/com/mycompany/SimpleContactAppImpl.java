package com.mycompany;

import javax.jws.WebService;

import com.mycompany.dao.ContactDAO;

/**
 * This is a simple webservice can be deployed along with a webapp
 * remember to use simple data types 
 * webservices interoperability simple data types
 * to access http://localhost:8080/ContactAppService?WSDL
 * @author ming
 *
 */
@WebService(serviceName="ContactAppService", portName="ContactService", endpointInterface = "com.mycompany.SimpleContactApp")
public class SimpleContactAppImpl implements SimpleContactApp {
	private ContactDAO contactDao;
	
	@Override
	public Contact getContact(String firstName) {
		return contactDao.getContact(1);
	}

	@Override
	public void insertAcontact(Contact contact) {
		contactDao.insertContact(contact);

	}

	public ContactDAO getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public String sayHello() {
		return "hello to you too";
	}

}
