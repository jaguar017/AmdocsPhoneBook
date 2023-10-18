package com.amdocs.project;
import java.util.TreeMap;

public class PhoneBook extends AbstractPhoneBook {
    private TreeMap<String, Contact> contactMap = new TreeMap<>();

    @Override
    public void addContact(Contact contact) {
        if (isContactValid(contact)) {
            contactMap.put(contact.getName(), contact);
            System.out.println("Contact added: " + contact.getName() + " - " + contact.getPhoneNumber());
        } else {
            System.out.println("Invalid contact data. Please check the name and phone number.");
        }
    }

    @Override
    public void removeContact(String name) {
        if (contactMap.containsKey(name)) {
            Contact removedContact = contactMap.remove(name);
            System.out.println("Contact removed: " + removedContact.getName());
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    @Override
    public Contact searchContact(String name) {
        return contactMap.get(name);
    }

    @Override
    public void listContacts() {
        System.out.println("PhoneBook Contacts (Sorted by Name):");
        for (Contact contact : contactMap.values()) {
            System.out.println(contact.getName() + " - " + contact.getPhoneNumber());
        }
    }

    private boolean isContactValid(Contact contact) {
        return !contact.getName().isEmpty() && isValidPhoneNumber(contact.getPhoneNumber())
            && !contactMap.containsKey(contact.getName());
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("[6-9]\\d{9}");
    }
}