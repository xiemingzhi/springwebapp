package com.mycompany.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mycompany.Contact;

@Repository
public class ContactDAOHibernate implements ContactDAO{
	protected final Log logger = LogFactory.getLog(getClass());
	
	@PersistenceContext(unitName="demoRestPersistenceLegacy")
	private EntityManager em;
	
	public void insertContact(Contact contact) {
		logger.debug("Inside ContactDAOHibernate.insert() method");
		this.em.persist(contact);
	}
	
	public List getContacts() {
		logger.debug("Inside ContactDAOHibernate.getContacts() method");
		TypedQuery<Contact> query = this.em.createQuery("select distinct contact from Contact as contact", Contact.class);
		return query.getResultList();
	}
	
	public Contact getContact(int contactId) {
		logger.debug("Inside ContactDAOHibernate.getContact() method");
		return (Contact)this.em.find(Contact.class, contactId);
	}
	
	public void updateContact(Contact contact) {
		logger.debug("Inside ContactDAOHibernate.updateContact() method");
		this.em.merge(contact);
	}
	
	public void deleteContact(int contactId) {
		logger.debug("Inside ContactDAOHibernate.deleteContact() method");
		Contact c = (Contact)this.em.find(Contact.class, contactId);
		if (c!=null) this.em.remove(c);
		else logger.debug("Inside ContactDAOHibernate.deleteContact() method no such id found");
	}
	
}
