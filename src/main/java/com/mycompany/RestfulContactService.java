package com.mycompany;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.dao.ContactDAO;

/**
 * http://localhost:8080/springwebapp/rest/contact/num
 * @author ming
 *
 */
@Component
@Path("/contact")
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
	
	@GET
	@Path("/num")
	@Produces("text/plain")
	public Response getContactNum() {
		String result = "number of contacts is "+contactDao.getContacts().size();
		return Response.status(200).entity(result).build();
	}

	@GET
	@Path("/xmllist")
	@Produces(MediaType.APPLICATION_XML)
	public ContactList getContactsXML() {
		ContactList cl = new ContactList();
		cl.setContacts(contactDao.getContacts());
		return cl;
	}
	
	@GET
	@Path("/jsonlist")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> getContactsJSON() {
		return contactDao.getContacts();
	}
	
	//post http://localhost:8080/springwebapp/rest/contact
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response createContact(Contact order) {
		contactDao.insertContact( order);
		logger.debug("contact created id;"+order.getContactId());
		return Response.status(201).entity(order).build();
    }
	
	@DELETE
	@Path("/{id}")
	public void deleteContact(@PathParam("id") String contactId) {
		contactDao.deleteContact(Integer.parseInt(contactId));
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateContact(Contact order) {
		logger.debug("contact updating id;"+order.getContactId());
		contactDao.updateContact( order);
		return Response.status(202).entity(order).build();
    }
	
}
