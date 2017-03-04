package com.mycompany.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.stereotype.Controller;

import com.mycompany.Contact;
import com.mycompany.ContactApp;
import com.mycompany.aop.NoContact;

@Controller
public class ContactAppController extends AbstractController {

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired @Qualifier("contact1") Contact contact1;
	
	String command;
		
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.debug("contact1 name " + contact1.getFirstName());
		NoContact nc = new NoContact();
		nc.showContactName();
		ModelAndView model = new ModelAndView("hello");
		model.addObject("msg", "hello world");

		return model;
	}

}
