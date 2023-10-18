package com.project.services;

import com.project.model.Contact;

public class ValidatePhoneBook{
	
	
	 public boolean isValidContactData(String name, String phoneNumber) {
		 PhoneBook pb1 = new PhoneBook();
	        if (!isValidName(name)) {
	            System.out.println("Invalid Name");
	            return false;
	        }

	        if (!isValidPhoneNumber(phoneNumber)) {
	            System.out.println("Invalid phone number format. It should be 10 digits starting with 6, 7, 8, or 9.");
	            return false;
	        }

	        if (pb1.getContactMap().containsKey(name)) {
	            System.out.println("Contact with the same name already exists.");
	            return false;
	        }

	        return true;
	    }
	    protected static boolean isValidPhoneNumber(String phoneNumber) {
	        return phoneNumber.matches("[6-9]\\d{9}");
	    }
	    
	    protected static boolean isValidName(String name) {
	        return name.matches("[a-zA-Z]{1,20}$");
	    }
	    
	    
	    protected boolean isContactValid(Contact contact) {
	    	 PhoneBook pb2 = new PhoneBook();
	        return !contact.getName().isEmpty() && isValidPhoneNumber(contact.getPhoneNumber())
	        		&& !pb2.getContactMap().containsKey(contact.getName());
	    }
	
	    
	

}
