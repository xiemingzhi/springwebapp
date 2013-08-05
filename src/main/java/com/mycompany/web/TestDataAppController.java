package com.mycompany.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.Contact;
import com.mycompany.dao.ContactDAO;

//@Controller
public class TestDataAppController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ContactDAO contactDao;
	@Autowired
	List<Contact> contactList;
	
	@RequestMapping(value="/addtestdata.htm")
	public ModelMap addtestdataHandler() {
		for (Contact c : contactList)
		{
			logger.debug("c firstname = " + c.getFirstName());
			logger.info("Returning hello view firstname;" + c.getFirstName());
			contactDao.insertContact(c);

		}
		return new ModelMap("msg", "number of contacts added : " + contactList.size());
	}
	
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		for (Contact c : contactList)
		{
			logger.debug("c firstname = " + c.getFirstName());
			logger.info("Returning hello view firstname;" + c.getFirstName());
			contactDao.insertContact(c);

		}
		
		return new ModelAndView("success", "msg", "number of contacts added : " + contactList.size());
	}

	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}

	public ContactDAO getContactDao() {
		return contactDao;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
