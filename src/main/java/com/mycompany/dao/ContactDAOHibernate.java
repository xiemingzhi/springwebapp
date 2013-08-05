package com.mycompany.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mycompany.Contact;


public class ContactDAOHibernate extends HibernateDaoSupport implements ContactDAO{
	protected final Log logger = LogFactory.getLog(getClass());
	
	public void insertContact(Contact contact) {
		logger.debug("Inside ContactDAOHibernate.insert() method");
		this.getHibernateTemplate().save(contact);
	}
	
	public List getContacts() {
		logger.debug("Inside ContactDAOHibernate.getContacts() method");
		return getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
				throws HibernateException, SQLException {

				StringBuffer sb = new StringBuffer(100);
				sb.append("select distinct contact ");
				sb.append("from Contact contact ");
				sb.append("order by contact.contactId");

				Query query = session.createQuery(sb.toString());
				List list = query.list();

				return list;
			}
		});		
	}
	
	public Contact getContact(int contactId) {
		logger.debug("Inside ContactDAOHibernate.getContact() method");
		return (Contact)getHibernateTemplate().get(Contact.class, contactId);
	}
	
	public void updateContact(Contact contact) {
		logger.debug("Inside ContactDAOHibernate.updateContact() method");
		this.getHibernateTemplate().update(contact);
	}
	
	public void deleteContact(int contactId) {
		logger.debug("Inside ContactDAOHibernate.deleteContact() method");
		Contact c = (Contact)getHibernateTemplate().get(Contact.class, contactId);
		if (c!=null) this.getHibernateTemplate().delete(c);
		else logger.debug("Inside ContactDAOHibernate.deleteContact() method no such id found");
	}
	
}
