package com.mycompany.web;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.mycompany.Contact;
import com.mycompany.ContactApp;

@Controller
@RequestMapping(value="/addcontact.htm")
public class AddContactFormController  {
	@Autowired
	ContactApp contactApp;
	
	public AddContactFormController() {
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getContactForm(Model model)
	{
		Contact contact = new Contact();
		model.addAttribute(contact);
		return "addcontact";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(@Valid Contact contact, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addcontact";
		} else {
			contactApp.insertAcontact(contact);
			model.addAttribute("contactList", contactApp.getAllContacts());
			return "listcontacts";
		}
	}
	
	/**
	 * more control but have to return modelandview
	@RequestMapping(method=RequestMethod.POST)
	protected String onSubmit(@ModelAttribute Contact command, BindingResult result, Model model)
			throws Exception {
		Contact student = (Contact) command;

		contactApp.insertAcontact(student);
		model.addAttribute("contactList", contactApp.getAllContacts());
		//return successview
		return "listcontacts";
	}
	 */
	
	/* basic call don't have to return modelandview 
	protected void doSubmitAction(Object command) throws Exception {

		Contact student = (Contact) command;
		System.out.println("user entered firstName;"+student.getFirstName());
		System.out.println("user entered lastName;"+student.getLastName());
		System.out.println("user entered email;"+student.getEmail());
		contactApp.insertAcontact(student);
	}
	*/
	
	public ContactApp getContactApp() {
		return contactApp;
	}
	public void setContactApp(ContactApp contactApp) {
		this.contactApp = contactApp;
	} 
	
}
