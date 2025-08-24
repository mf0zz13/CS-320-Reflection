package ContactServiceTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ContactService.Contact;

public class ContactTest {
	
	private Object[][] invalidConstructors = {
			{"01234567891", "Michael", "Foster", "1234567890", "1234 Test Address"}, //Contact id too long
            {"0123456789", "MichaelFoster", "Foster", "1234567890", "1234 Test Address"}, // First name too long
            {"0123456789", "Michael", "MichaelFoster", "1234567890", "1234 Test Address"}, // Last name too long
            {"0123456789", "Michael", "Foster", "12345678901", "1234 Test Address"}, // Phone number too long
            {"0123456789", "Michael", "Foster", "123456789A", "1234 Test Address"}, // Phone number contains a letter
            {"0123456789", "Michael", "Foster", "1234567890", "1234 Test Address 1234 Test Address"}, // Address too long
            {null, "Michael", "Foster", "1234567890", "1234 Test Address"}, // Contact id null
            {"0123456789", null, "Foster", "1234567890", "1234 Test Address"}, // First name null
            {"0123456789", "Michael", null, "1234567890", "1234 Test Address"}, // Last name null
            {"0123456789", "Michael", "Foster", null, "1234 Test Address"}, // Phone number null
            {"0123456789", "Michael", "Foster", "1234567890", null} // Address null
	};

    @Test
    public void TestAddContact() {
        for (Object[] input: invalidConstructors) { // Verifying an exception is thrown for all invalid constructors
        	assertThrows(IllegalArgumentException.class, () -> {
        		new Contact(
        				(String) input[0],
        				(String) input[1],
        				(String) input[2],
        				(String) input[3],
        				(String) input[4]);
        	});    	
        }
        
        assertDoesNotThrow(() -> { // Verifying that correct values do not set off exception
        	new Contact(
        		"0123456789",
        		"Michael",
        		"Foster",
        		"1234567890",
        		"1234 Test Address");
        });
    }

    @Test
    public void TestGetMethods() { // Verifying that get methods return the correct values
    	Contact testContact = new Contact(
    			"0123456789",
        		"Michael",
        		"Foster",
        		"1234567890",
        		"1234 Test Address");
    	assertEquals("0123456789", testContact.GetContactId());
    	assertEquals("Michael", testContact.GetFirstName());
    	assertEquals("Foster", testContact.GetLastName());
    	assertEquals("1234567890", testContact.GetPhoneNumber());
    	assertEquals("1234 Test Address", testContact.GetAddress());   	
    }
}