package com.mycompany.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mycompany.Contact;

public class AddContactValidator implements Validator {

	@Override
	public boolean supports(Class arg0) {
		// TODO Auto-generated method stub
		return Contact.class.equals(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		ValidationUtils.rejectIfEmpty(arg1, "firstName", "firstname.empty");
		
	}

}
