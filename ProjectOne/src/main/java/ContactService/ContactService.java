package ContactService; 

import java.util.HashMap;

public class ContactService { 

    public HashMap<String, Contact> contacts = new HashMap<String,Contact>(); // Holds all contacts
    
    private String GenerateUniqueID() { 
    	String uniqueID = null;
    	
    	do {
    		uniqueID = Integer.toString((int)((Math.random())*1000000001)); // generate random number and covert to string
    	} while (contacts.containsKey(uniqueID)); // continue until a unique value is found
    	
    	return uniqueID;
    }
    
    public Boolean CheckForID(String uniqueID) { // Checks if uniqueID is in hashmap
    	if (contacts.containsKey(uniqueID))
    		return true;
    	else
    		throw new IllegalArgumentException("Contact ID is not valid");
    }
    
    public String AddContact (String firstName, String lastName, String number, String address){ // creates new contact object and adds to hashmap
    	String uniqueID = GenerateUniqueID();
    	Contact tempContact = new Contact(uniqueID, firstName,lastName,number,address);       
    	contacts.put(uniqueID, tempContact);
    	return uniqueID;
    }

    public void DeleteContact(String uniqueID) { // deletes contact object form hashmap
       if (CheckForID(uniqueID))
           contacts.remove(uniqueID);
    }

    public void UpdateFirstName(String uniqueID, String firstName) { // updates contact objects first name
    	if (CheckForID(uniqueID)) {
            Contact tempContact = contacts.get(uniqueID);
            tempContact.SetFirstName(firstName);}
    }

    public void UpdateLastName(String uniqueID, String lastName) { // updates contact objects last name
    	if (CheckForID(uniqueID)) {
        	Contact tempContact = contacts.get(uniqueID);
            tempContact.SetLastName(lastName);}
    }
    
    public void UpdateNumber(String uniqueID, String number) { // updates contact objects number
    	if (CheckForID(uniqueID)) {
            Contact tempContact = contacts.get(uniqueID);
            tempContact.SetPhoneNumber(number);}
    }
    public void UpdateAddress(String uniqueID, String address) { // updates contact objects address
        if (CheckForID(uniqueID)) {
            Contact tempContact = contacts.get(uniqueID);
            tempContact.setAddress(address);}
    }
}