package com.mycompany.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mycompany.Contact;

@Configurable
public class NoContact {

	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired  @Qualifier("contact2") Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	public void showContactName() {
		logger.debug("nocontact name " + contact.getFirstName());
	}
}
