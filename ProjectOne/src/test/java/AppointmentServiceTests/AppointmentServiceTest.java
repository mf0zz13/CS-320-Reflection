package AppointmentServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;
import AppointmentService.AppointmentService;
import ContactService.Contact;
import ContactService.ContactService;

class AppointmentServiceTest {
	private Date currDate = new Date();

	@Test
	public void TestAddAppointment() { // Testing that when a new appointment object is added its fields are correct
		AppointmentService testAppointmentService = new AppointmentService();
		String appointmentID = testAppointmentService.AddAppointment((new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), "Description");
		assertEquals((new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), testAppointmentService.appointments.get(appointmentID).GetAppointmentDate());
		assertEquals("Description", testAppointmentService.appointments.get(appointmentID).GetAppointmentDescription());
	}
	
	@Test
	public void TestIDCheck() { // Verifying that when the appointmentID is not in the hashmap an exception is raised
		ContactService testContactService = new ContactService();
		assertThrows(IllegalArgumentException.class, () -> {testContactService.CheckForID("-1");});
	}
	
	@Test
	public void TestDeleteAppointment() { // Verifying that appointment is successfully removed from hashmap when deleted
		AppointmentService testAppointmentService = new AppointmentService();
		String appointmentID = testAppointmentService.AddAppointment((new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), "Description");
		testAppointmentService.deleteAppointment(appointmentID);
		assertTrue(testAppointmentService.appointments.isEmpty());
	}
}