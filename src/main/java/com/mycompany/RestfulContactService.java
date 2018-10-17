package com.mycompany;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.dao.ContactDAO;
import org.springframework.web.multipart.MultipartFile;

/**
 * http://localhost:8080/springwebapp/rest/contact/num
 * @author ming
 *
 */
@RestController
@RequestMapping("/contact")
public class RestfulContactService {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	ContactDAO contactDao;
	
	@RequestMapping(value = "/num", method = RequestMethod.GET, produces = "text/plain")
	public String getContactNum() {
		String result = "number of contacts is "+contactDao.getContacts().size();
		return (result);
	}

	@RequestMapping(value = "/xmllist", method = RequestMethod.GET, produces = "application/xml")
	public ContactList getContactsXML() {
		ContactList cl = new ContactList();
		cl.setContacts(contactDao.getContacts());
		return cl;
	}
	
	@RequestMapping(value = "/jsonlist", method = RequestMethod.GET, produces = "application/json")
	public ContactList getContactsJSON() {
		List<Contact> contactList = contactDao.getContacts();
		ContactList cl = new ContactList();
		cl.setContacts(contactList);
		return cl;
	}
	
	//post http://localhost:8080/springwebapp/rest/contact
	@RequestMapping( method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Contact createContact(Contact order) {
		contactDao.insertContact( order);
		logger.debug("contact created id;"+order.getContactId());
		return order;
    }
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")	
	public void deleteContact(@PathVariable("id") String contactId) {
		contactDao.deleteContact(Integer.parseInt(contactId));
	}
	@RequestMapping( method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")	
    public Contact updateContact(Contact order) {
		logger.debug("contact updating id;"+order.getContactId());
		contactDao.updateContact( order);
		return order;
    }

	@PostMapping("/uploadExcelFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException {
		InputStream in = file.getInputStream();
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
		FileOutputStream f = new FileOutputStream(fileLocation);
		int ch = 0;
		while ((ch = in.read()) != -1) {
			f.write(ch);
		}
		f.flush();
		f.close();
		model.addAttribute("message", "File: " + file.getOriginalFilename()
				+ " has been uploaded successfully!");
		return "excel";
	}
}
