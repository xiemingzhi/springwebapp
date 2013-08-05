package com.mycompany.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.Contact;
import com.mycompany.ContactApp;

/**
 * http://localhost:8080/springwebapp/contactapp/contacts/list.htm
 * @author ming
 *
 */
@Controller
@RequestMapping("/contactapp/contacts")
public class JSONController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ContactApp contactApp;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public @ResponseBody DataTablesResponse<Contact> getContactsByJSON() {
		logger.debug("inside getcontactsbyjson");
		DataTablesResponse dtr = new DataTablesResponse();
		List<Contact> arr = new ArrayList<Contact>();
		arr = contactApp.getAllContacts();
		dtr.data = arr;
		dtr.echo = "1";
		dtr.columns = "4";
		dtr.totalRecords = arr.size();
		dtr.totalDisplayRecords = arr.size();
		return dtr;
 
	}

}
