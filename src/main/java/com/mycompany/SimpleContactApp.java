package com.mycompany;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Exposing web services using JAX-WS
 * @author ming
 *
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC, use=SOAPBinding.Use.LITERAL)
public interface SimpleContactApp {
	@WebResult(name="return")
	public Contact getContact(String firstName);
	public void insertAcontact(Contact contact);
	public String sayHello();
}
