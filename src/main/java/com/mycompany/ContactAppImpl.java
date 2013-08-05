package com.mycompany;

import java.util.Collection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mycompany.dao.ContactDAO;

/**
 * @author testuser
 *
 */
public class ContactAppImpl implements ContactApp {
	protected final Log logger = LogFactory.getLog(getClass());
	private List<Contact> contactList;
	private ContactDAO contactDao;

	public ContactAppImpl() {
		
	}
	
	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	
	public ContactDAO getContactDao() {
		return contactDao;
	}

	public void setContactDao(ContactDAO contactDao) {
		this.contactDao = contactDao;
	}

	/* (non-Javadoc)
	 * @see com.sample.ContactApp#getContact(java.lang.String)
	 */
	public Contact getContact(String firstName) {
		
		Contact c = new Contact();
		c.setFirstName(firstName);
		return c;
	}

	@Override
	public List<Contact> getAllContacts() {
		
		
		return contactDao.getContacts();
	}

	@Override
	public void insertContacts(List<Contact> contactList) {
		
		for (Contact c : contactList)
		{
			logger.debug("c firstname = " + c.getFirstName());
			logger.info("Returning hello view firstname;" + c.getFirstName());
			contactDao.insertContact(c);

		}
	}

	@Override
	public int getNumberOfContacts() {
		
		return contactList.size();
	}

	@Override
	public void insertAcontact(Contact contact) {
		contactDao.insertContact(contact);
		
	}

	@Override
	public boolean containsEmail(String email) {
		Collection<Contact> c = contactDao.getContacts();
		for (Contact contact : c)
		{
			if (contact.getEmail().equals(email))
			{
				return true;
			}
		}
		return false ;
	}

}
