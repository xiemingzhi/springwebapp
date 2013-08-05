package com.mycompany;

import java.util.Collection;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * @author testuser
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ContactApp {
	public Contact getContact(String firstName);
	public List<Contact> getAllContacts();
	public void insertContacts(List<Contact> contactList);
	public void insertAcontact(Contact contact);
	public int getNumberOfContacts();
	public boolean containsEmail(String email);
}
