package com.mycompany.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.Contact;
import com.mycompany.ContactList;
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
		String result = "number of contacts is "+contactDao.getContacts().size();
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/xmllist", method = RequestMethod.GET, produces = "application/xml")
	public @ResponseBody ResponseEntity<Object> getContactsXML() {
		ContactList cl = new ContactList();
		cl.setContacts(contactDao.getContacts());
		return new ResponseEntity<Object>(cl, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/jsonlist", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ResponseEntity<List<Contact>> getContactsJSON() {
		logger.debug("inside getcontactsjson");
		return new ResponseEntity<List<Contact>>(contactDao.getContacts(), HttpStatus.OK);
	}
	
	//post http://localhost:8080/springwebapp/rest/contact
	@RequestMapping( method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public @ResponseBody ResponseEntity<Object> createContact(Contact order) {
		contactDao.insertContact( order);
		logger.debug("contact created id;"+order.getContactId());
		return new ResponseEntity<Object>(order, HttpStatus.OK);
    }
	
	/*@DELETE
	@Path("/{id}")
	public void deleteContact(@PathParam("id") String contactId) {
		contactDao.deleteContact(Integer.parseInt(contactId));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody ResponseEntity<Object> updateContact(Contact order) {
		logger.debug("contact updating id;"+order.getContactId());
		contactDao.updateContact( order);
		return Response.status(202).entity(order).build();
    }*/
	
}
