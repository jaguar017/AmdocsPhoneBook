package com.project.test;

import java.util.Scanner;

import com.project.model.Contact;
import com.project.services.ValidatePhoneBook;
import com.project.services.PhoneBook;

public class PhoneBookApp {

	public static void main(String[] args) {
    	
    	ValidatePhoneBook vb = new ValidatePhoneBook();
        PhoneBook phoneBook = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("PhoneBook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contact");
            System.out.println("4. List Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    if (vb.isValidContactData(name, phoneNumber)) {
                        phoneBook.addContact(new Contact(name, phoneNumber));
                    }
                    break;
                case 2:
                    System.out.print("Enter name to remove: ");
                    String removeName = sc.nextLine();
                    phoneBook.removeContact(removeName);
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    Contact contact = phoneBook.searchContact(searchName);
                    if (contact != null) {
                        System.out.println("Contact found: " + contact.getName() + " - " + contact.getPhoneNumber());
                    } else {
                        System.out.println("Contact not found: " + searchName);
                    }
                    break;
                case 4:
                    phoneBook.listContacts();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting PhoneBook. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   
}

