// ContactList by James Yue 1/19/24

// This application allows users to store the name, phone number, and other
// information of a person into a contact list. The user will be able to add new
// contacts, list existing ones, search for a specific contact, and choose
// the order of their contact list.

import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    // Instance variable that can hold both Student and Athlete objects
    private ArrayList<Person> contacts;

    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }
    // Initializng a scanner
    Scanner input = new Scanner(System.in);

    // Getter function for contacts
    public ArrayList<Person> getContacts() {
        return contacts;
    }


    public void addContact() {
        // Determine if the user wants to add a Student object or an Athlete object
        // because the two classes have a different instance variable than each other
        System.out.println("Select a type of contact to add: \n 1. Student \n 2. Athlete");
        int typeOfContact = input.nextInt();
        input.nextLine();
        // Ask for instance variables that are both in Student and Athlete class
        System.out.println("Please fill in the following information. \nFirst Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();

        // If the user chooses to create a Student object, they will be prompted
        // with the Student's instance variable
        if (typeOfContact == 1) {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            // Create a new Student object filled with the user's input
            Student newContact = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(newContact);
        }
        // If the user chooses to create an Athlete object, they will be prompted
        // with the Athlete's instance variable
        else {
            System.out.println("Sport: ");
            String sport = input.nextLine();
            // Create a new Athlete object filled with the user's input
            Athlete newContact = new Athlete(firstName, lastName, phoneNumber, sport);
            contacts.add(newContact);
        }
    }

    // Loop through the contact list and print out all the contacts
    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    // The user can choose to sort the contact list in three ways
    // 1. By first name 2. By last name 3. By phone number
    // Using the Bubble sort method
    public void sort(int sortBy) {
        // Storing the size of the array
        int arrayLength = contacts.size();

        // Sorted by first name
        if (sortBy == 0) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    // Determines if the first letter of a person's first name is lexicographicaly greater
                    // than the person to its right (1 index above)
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0)  {
                        // Makes a copy of the person's information before it gets swapped
                        Person temp = contacts.get(j);
                        // Swaps the right index with the left
                        contacts.set(j, contacts.get(j + 1));
                        // Swaps the temp (formerly the left) with the right
                        contacts.set(j + 1, temp);
                    }
                }
            }
            // Print out the contacts which are now organized by first name
            for (Person contact : contacts) {
                System.out.println(contact);
            }
        }

        // Sorted by last name
        if (sortBy == 1) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    // Determines if the first letter of a person's last name is lexicographicaly greater
                    // than the person to its right (1 index above)
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0)  {
                        // Makes a copy of the person's information before it gets swapped
                        Person temp = contacts.get(j);
                        // Swaps the right index with the left
                        contacts.set(j, contacts.get(j + 1));
                        // Swaps the temp (formerly the left) with the right
                        contacts.set(j + 1, temp);
                    }
                }
            }
            // Print out the contacts which are now organized by last name
            for (Person contact : contacts) {
                System.out.println(contact);
            }
        }

        // Sorted by phone number
        if (sortBy == 2) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    // Determines if the first number of a person's phone number is lexicographicaly greater
                    // than the person to its right (1 index above)
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0)  {
                        // Makes a copy of the person's information before it gets swapped
                        Person temp = contacts.get(j);
                        // Swaps the right index with the left
                        contacts.set(j, contacts.get(j + 1));
                        // Swaps the temp (formerly the left) with the right;
                        contacts.set(j + 1, temp);
                    }
                }
            }
            // Print out the contacts which are now organized by phone number
            for (Person contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    // Loops through the contact list comparing the user's input to the first name's
    // of people in the contact list
    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        return null; // The user's input does not match the first name of anyone in the contact list
    }

    // Loops through the contact list comparing the user's input to the last name
    // of people in the contact list
    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        return null; // The user's input does not match the last name of anyone in the contact list
    }

    // Loops through the contact list comparing the user's input to the phone number
    // of people in the contact list
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null; // The user's input does not match the phone number of anyone in the contact list
    }

    // Find and list all the Students in the array contacts
    public Person listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
        return null; // There are no Student objects in the contact list
    }

    public void run() {
        boolean hasEnded = false;

        // Continuously ask the user for input until they exit by typing "0"
        while (!hasEnded) {
            System.out.println("Menu: \n1. Add Contact \n2. List All Contacts By First" +
                    " Name List \n3. List All Contacts By Last Name \n4. List All Contacts " +
                    "By Phone Number \n5. List All Students \n6. Search by First Name \n" +
                    "7. Search By Last Name \n8. Search By Phone Number \n0. Exit");
            // Store the user's input of what they want the application to do
            int inquiry = input.nextInt();
            input.nextLine();

            // Add contact
            if (inquiry == 1) {
                addContact();
            }
            // List contacts by first name
            else if (inquiry == 2) {
                sort(0);
            }
            // List contacts by last name
            else if (inquiry == 3) {
                sort(1);
            }
            // List contacts by phone number
            else if (inquiry == 4) {
                sort(2);
            }
            // List contacts if they're a Student
            else if (inquiry == 5) {
                listStudents();
            }
            // Search by first name
            else if (inquiry == 6) {
                System.out.println("Enter a first name: ");
                String firstName = input.nextLine();
                // If the name the user provided does not match any of first names in the contact list
                // report that it does not exist in the list
                if (searchByFirstName(firstName) == null) {
                    System.out.println(firstName + " is not in the list.");
                }
                else {
                    System.out.println(searchByFirstName(firstName));
                }
            }
            // Search by last name
            else if (inquiry == 7) {
                System.out.println("Enter a last name: ");
                String lastName = input.nextLine();
                // If the name the user provided does not match any of last names in the contact list
                // report that it does not exist in the list
                if (searchByLastName(lastName) == null) {
                    System.out.println(lastName + " is not in the list.");
                }
                else {
                    System.out.println(searchByLastName(lastName));
                }
            }
            // Search by phone number
            else if (inquiry == 8) {
                System.out.println("Enter a phone number: ");
                String phoneNumber = input.nextLine();
                // If the phone number the user provided does not match any of first names in the contact list
                // report that it does not exist in the list
                if (searchByPhoneNumber(phoneNumber) == null) {
                    System.out.println(phoneNumber + " is not in the list.");
                }
                else {
                    System.out.println(searchByPhoneNumber(phoneNumber));
                }
            }
            // Exists out of the program
            else if (inquiry == 0){
                hasEnded = true;
            }
        }
    }
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}