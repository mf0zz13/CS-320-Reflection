package ContactServiceTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ContactService.ContactService;
import ContactService.Contact;

public class ContactServiceTest {         

	@Test
	public void TestAddContacts() { // Verifying that the when a contact is added the variables are correctly stored in the contact objects fields
		ContactService testContactService = new ContactService();
		String uniqueID = testContactService.AddContact("Michael", "Foster", "1234567890", "1234 Test Address");
		assertEquals("Michael", testContactService.contacts.get(uniqueID).GetFirstName());
		assertEquals("Foster",testContactService.contacts.get(uniqueID).GetLastName());
	    assertEquals("1234567890",testContactService.contacts.get(uniqueID).GetPhoneNumber());
	    assertEquals("1234 Test Address",testContactService.contacts.get(uniqueID).GetAddress());
	}

	@Test
	public void TestIDCheck() { // Verifying that if a contactID is not in hashmap an exception is thrown
		ContactService testContactService = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> {testContactService.CheckForID("-1");});
		
	}

   @Test
    public void TestDeleteContact() { // Verifying that once a contact object that is stored in the hashmap is deleted that it no longer remains in hashmap
        ContactService testContactService = new ContactService();
        String uniqueID = testContactService.AddContact("Michael", "Foster", "1234567890", "1234 Test Address");
        testContactService.DeleteContact(uniqueID);
        assertTrue(testContactService.contacts.isEmpty());
   }

   @Test
    public void TestUpdateFields() { // Verifying that an exception is not thrown when updating fields and that the contact object's fields are correct post updates
	   ContactService testContactService = new ContactService();
       String uniqueID = testContactService.AddContact("Michael", "Foster", "1234567890", "1234 Test Address");

        assertDoesNotThrow(()->testContactService.UpdateFirstName(uniqueID,"Foster"));
        assertDoesNotThrow(()->testContactService.UpdateLastName(uniqueID, "Michael"));
        assertDoesNotThrow(()->testContactService.UpdateNumber(uniqueID,"0000000000"));
        assertDoesNotThrow(()->testContactService.UpdateAddress(uniqueID,"0123456789 road 01234567890123"));

        Contact testContact = testContactService.contacts.get(uniqueID);
        assertEquals("Foster",testContact.GetFirstName());
        assertEquals("Michael",testContact.GetLastName());
        assertEquals("0000000000",testContact.GetPhoneNumber());
        assertEquals("0123456789 road 01234567890123",testContact.GetAddress());
   }
}