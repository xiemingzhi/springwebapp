
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.UncategorizedSQLException;

import com.mycompany.Contact;


/**
 * @author testuser
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ContactDAOJDBC implements ContactDAO {
	/* (non-Javadoc)
	 * @see com.sample.dao.ContactDAO#insertContact(com.sample.Contact)
	 */
	public void insertContact(Contact contact) {
		System.out.println("Inside ContactDAOJDBC.insertContact() method");
	}

	/* (non-Javadoc)
	 * @see com.sample.dao.ContactDAO#getContacts()
	 */
	public List getContacts() {
		System.out.println("Inside ContactDAOJDBC.getContacts() method");
		return new ArrayList();
	}

	/* (non-Javadoc)
	 * @see com.sample.dao.ContactDAO#getContact(int)
	 */
	public Contact getContact(int contactId) {
		System.out.println("Inside ContactDAOJDBC.getContact() method");
		return new Contact();
	}

	/* (non-Javadoc)
	 * @see com.sample.dao.ContactDAO#updateContact(com.sample.Contact)
	 */
	public void updateContact(Contact contact) {
		System.out.println("Inside ContactDAOJDBC.updateContact() method");
	}

	/* (non-Javadoc)
	 * @see com.sample.dao.ContactDAO#deleteContact(int)
	 */
	public void deleteContact(int contactId) {
		System.out.println("Inside ContactDAOJDBC.deleteContact() method");
	}

}