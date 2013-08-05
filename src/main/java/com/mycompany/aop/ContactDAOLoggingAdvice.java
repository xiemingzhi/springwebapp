
package com.mycompany.aop;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import com.mycompany.Contact;

/**
 * @author testuser
 *
 Basic logging advice 
 */
public class ContactDAOLoggingAdvice implements AfterReturningAdvice {

	protected final Log logger = LogFactory.getLog(getClass());

	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		String methodName = arg1.getName();
		logger.debug("The method you called " + methodName + " executed successfully. ");
		Contact c = (Contact) arg2[0];
		logger.debug("The contact's firstname is " + c.getFirstName());
		
	}

}
