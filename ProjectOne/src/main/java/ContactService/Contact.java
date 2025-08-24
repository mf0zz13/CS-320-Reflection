package ContactService;
public class Contact {
    private String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
    	SetContactID(contactID); 
        SetFirstName(firstName);
        SetLastName(lastName);
        SetPhoneNumber(phoneNumber);
        setAddress(address);
    }
    
    // Method to validate that string is not null or greater than 10 characters long
    private String ValidateInput(String input) {
    	if (input == null || input.length() > 10)
    		throw new IllegalArgumentException("Invalid input");
    	else 
    		return input;
    }

    
    public void SetContactID(String contactID) { 
    	this.contactID = ValidateInput(contactID);
    }   
    public String GetContactId() {return contactID;}

    
    public void SetFirstName(String firstName) {
      this.firstName = ValidateInput(firstName);
    }
    public String GetFirstName() {return firstName;}

    
    public void SetLastName(String lastName) {
        this.lastName = ValidateInput(lastName);
    }    
    public String GetLastName() {return lastName;}
    
     
    public void SetPhoneNumber(String phoneNumber) {
        if (ValidateInput(phoneNumber).chars().anyMatch(Character::isAlphabetic)) // checks if any numbers have been passed in phone number and throws exception if so
        	throw new IllegalArgumentException("Phone number must consist of numbers");
        else
        	this.phoneNumber = phoneNumber;
    }
    public String GetPhoneNumber() {return phoneNumber;}
    

    public void setAddress(String address) {
        if (address == null || address.length() > 30) // Check that input is valid
            throw new IllegalArgumentException("Input string is invalid");
        else
            this.address = address;
    }
    public String GetAddress() {return address;}

}