package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.dao.ContactDAO;

/**
 * http://localhost:8080/springwebapp/rest/contact/num
 * @author ming
 *
 */
@Controller
@RequestMapping("/contact")
public class RestfulContactService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ContactDAO contactDao;
	
	/*public ContactDAO getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}*/
	@RequestMapping(value = "/num", method = RequestMethod.GET, produces = "text/plain")
	public @ResponseBody ResponseEntity<Object> getContactNum() {
		int count = 0;
		for (Contact c : contactDao.findAll()) {
			count++;
		}
		String result = "number of contacts is "+count;
		return new ResponseEntity<Object>((result), HttpStatus.OK);
	}

	@RequestMapping(value = "/xmllist", method = RequestMethod.GET, produces = "application/xml")
	public ContactList getContactsXML() {
		ContactList cl = new ContactList();
		for (Contact c : contactDao.findAll()) {
			cl.getContacts().add(c);
		}
		return cl;
	}
	
	@RequestMapping(value = "/jsonlist", method = RequestMethod.GET, produces = "application/json")
	public List<Contact> getContactsJSON() {
		List<Contact> cl = new ArrayList<Contact>();
		for (Contact c : contactDao.findAll()) {
			cl.add(c);
		}
		return cl;
	}
	
	//post http://localhost:8080/springwebapp/rest/contact
	@RequestMapping( method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<Object> createContact(Contact order) {
		contactDao.save( order);
		logger.debug("contact created id;"+order.getContactId());
		return new ResponseEntity<Object>((order), HttpStatus.OK);
    }
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")	
	public void deleteContact(@PathVariable("id") String contactId) {
		contactDao.delete(Integer.parseInt(contactId));
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")	
    public @ResponseBody ResponseEntity<Object> updateContact(Contact order) {
		logger.debug("contact updating id;"+order.getContactId());
		contactDao.save( order);
		return new ResponseEntity<Object>((order), HttpStatus.OK);
    }
	
}
