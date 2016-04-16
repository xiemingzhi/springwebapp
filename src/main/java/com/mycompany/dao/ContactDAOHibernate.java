package com.mycompany.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mycompany.Contact;

public class ContactDAOHibernate implements ContactDAO{
	protected final Log logger = LogFactory.getLog(getClass());

	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void insertContact(Contact contact) {
		logger.debug("Inside ContactDAOHibernate.insert() method");
		sessionFactory.getCurrentSession().save(contact);
	}
	
	public List getContacts() {
		logger.debug("Inside ContactDAOHibernate.getContacts() method");
		Query query = sessionFactory.getCurrentSession().createQuery("select distinct contact from Contact contact order by contact.contactId");
		List list = query.list();
		return list;
	}
	
	public Contact getContact(int contactId) {
		logger.debug("Inside ContactDAOHibernate.getContact() method");
		return (Contact)sessionFactory.getCurrentSession().get(Contact.class, contactId);
	}
	
	public void updateContact(Contact contact) {
		logger.debug("Inside ContactDAOHibernate.updateContact() method");
		this.sessionFactory.getCurrentSession().update(contact);
	}
	
	public void deleteContact(int contactId) {
		logger.debug("Inside ContactDAOHibernate.deleteContact() method");
		Contact c = (Contact)sessionFactory.getCurrentSession().get(Contact.class, contactId);
		if (c!=null) this.sessionFactory.getCurrentSession().delete(c);
		else logger.debug("Inside ContactDAOHibernate.deleteContact() method no such id found");
	}
	
}
