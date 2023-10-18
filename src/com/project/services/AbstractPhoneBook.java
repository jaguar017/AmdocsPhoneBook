package com.project.services;

import com.project.model.Contact;

public abstract class AbstractPhoneBook {
    public abstract void addContact(Contact contact);
    public abstract void removeContact(String name);
    public abstract Contact searchContact(String name);
    public abstract void listContacts();
}