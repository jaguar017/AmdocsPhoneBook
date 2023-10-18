package com.project.services;

import java.util.TreeMap;

import com.project.model.Contact;

public class PhoneBook {
    private TreeMap<String, Contact> contactMap = new TreeMap<>();

    
    public void addContact(Contact contact) {
    	ValidatePhoneBook vb1 = new ValidatePhoneBook();
        if (vb1.isValidContactData(contact.getName(),contact.getPhoneNumber())) {
            contactMap.put(contact.getName(), contact);
            System.out.println("Contact added: " + contact.getName() + " - " + contact.getPhoneNumber());
        } else {
            System.out.println("Invalid contact data. Please check the name and phone number.");
        }
    }

    
    public void removeContact(String name) {
        if (contactMap.containsKey(name)) {
            Contact removedContact = contactMap.remove(name);
            System.out.println("Contact removed: " + removedContact.getName());
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

   
    public Contact searchContact(String name) {
        return contactMap.get(name);
    }

    
    public void listContacts() {
        System.out.println("PhoneBook Contacts (Sorted by Name):");
        for (Contact contact : contactMap.values()) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
        }
    }

	public TreeMap<String, Contact> getContactMap() {
		return contactMap;
	}

	public void setContactMap(TreeMap<String, Contact> contactMap) {
		this.contactMap = contactMap;
	}
    
    
    
}