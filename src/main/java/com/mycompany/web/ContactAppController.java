package com.mycompany.web;

import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import com.mycompany.ContactApp;
import com.mycompany.service.SlowService;

@Controller
public class ContactAppController {

	protected final Log logger = LogFactory.getLog(getClass());
	
	String command;
	@Autowired
	ContactApp contactApp;
	@Autowired
	SlowService slowService;
	
	public ContactApp getContactApp() {
		return contactApp;
	}

	public void setContactApp(ContactApp contactApp) {
		this.contactApp = contactApp;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@RequestMapping(value="/listcontacts.htm")
	public Callable<String> listcontactsHandler(Model model) {
		//model.addAttribute("contactList",contactApp.getAllContacts());
		Callable<String> asyncTask = new Callable<String>() {
			 
		      @Override
		      public String call() throws Exception {
		        return slowService.doSlowWork();
		      }
		    };
		     
		    logger.info("Leaving  controller");
		    return asyncTask;
	}

	@RequestMapping(value="/occupied.htm")
	public @ResponseBody boolean isOccupiedHandler(@RequestParam String email) {
		logger.debug("inside isOccupiedHandler containsEmail is " + contactApp.containsEmail(email));
		return contactApp.containsEmail(email);
	}
	
}
