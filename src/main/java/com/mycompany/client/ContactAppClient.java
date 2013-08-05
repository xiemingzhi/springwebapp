
package com.mycompany.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycompany.Contact;
import com.mycompany.ContactApp;
import com.mycompany.dao.ContactDAO;

/**
 * @author testuser
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ContactAppClient {

	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mycompany/client/contactcontext.xml");
			//
			ContactApp conapp = (ContactApp) ctx.getBean("contactApp");
			Contact c = conapp.getContact("john");
			System.out.println("c firstname = " + c.getFirstName());
			Contact c1 = (Contact) ctx.getBean("contact1");
			System.out.println("c1="+c1);
		} catch (BeansException e) {
			e.printStackTrace();
		}

	}
}
