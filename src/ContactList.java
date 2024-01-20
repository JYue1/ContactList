// ContactList by James Yue 1/19/24

import java.util.ArrayList;
import java.util.Scanner;
public class ContactList {

    private ArrayList<Person> contacts;
    Scanner input = new Scanner(System.in);

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact() {
        System.out.println("Select a type of contact to add: \n 1. Student \n 2. Athlete");
        int typeOfContact = input.nextInt();
        input.nextLine();
        System.out.println("Please fill in the following information. \nFirst Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();

        if (typeOfContact == 1) {
            System.out.println("Grade: ");
            int grade = input.nextInt();
            Student newContact = new Student(firstName, lastName, phoneNumber, grade);
            contacts.add(newContact);
        }
        else {
            System.out.println("Sport: ");
            String sport = input.nextLine();
            Athlete newContact = new Athlete(firstName, lastName, phoneNumber, sport);
            contacts.add(newContact);
        }
    }

    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        int arrayLength = contacts.size();

        if (sortBy == 0) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0)  {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
            for (Person contact : contacts) {
                System.out.println(contact);
            }
        }

        if (sortBy == 1) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0)  {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
            for (Person contact : contacts) {
                System.out.println(contact);
            }
        }

        if (sortBy == 2) {
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - 1 - i; j++) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0)  {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
            for (Person contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (contact.getFirstName().equals(firstName)) {
                return contact;
            }
        }
        System.out.println(firstName + " is not in the list");
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (contact.getLastName().equals(lastName)) {
                return contact;
            }
        }
        System.out.println(lastName + " is not in the list");
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        System.out.println(phoneNumber + " is not in the list");
        return null;
    }

    public Person listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                return contact;
            }
        }
        return null;
    }

    public void run() {
        boolean hasEnded = false;

        while (!hasEnded) {
            System.out.println("Menu: \n1. Add Contact \n2. List All Contacts By First" +
                    " Name List \n3. List All Contacts By Last Name \n4. List All Contacts " +
                    "By Phone Number \n5. List All Students \n6. Search by First Name \n" +
                    "7. Search By Last Name \n8. Search By Phone Number \n0. Exit");
            int inquiry = input.nextInt();
            input.nextLine();

            if (inquiry == 1) {
                addContact();
            }
            else if (inquiry == 2) {
                sort(0);
            }
            else if (inquiry == 3) {
                sort(1);
            }
            else if (inquiry == 4) {
                sort(2);
            }
            else if (inquiry == 5) {
                listStudents();
            }
            else if (inquiry == 6) {
                System.out.println("Enter a first name: ");
                String firstName = input.nextLine();
                System.out.println(searchByFirstName(firstName));
            }
            else if (inquiry == 7) {
                System.out.println("Enter a last name: ");
                String lastName = input.nextLine();
                System.out.println(searchByLastName(lastName));
            }
            else if (inquiry == 8) {
                System.out.println("Enter a phone number: ");
                String phoneNumber = input.nextLine();
                System.out.println(searchByPhoneNumber(phoneNumber));
            }
            else {
                hasEnded = true;
            }
        }
    }
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        contactList.run();
    }
}