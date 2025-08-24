package AppointmentServiceTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import AppointmentService.Appointment;
import java.util.Date;


public class AppointmentTest {
    private Date currDate = new Date();
    private Object[][] invalidConstructors = {
            {"01234567891", (new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), "01234567890123456789012345678901234567890123456789"}, // Invalid appointmentID length
            {"0123456789", new Date(125, 7, 7), "01234567890123456789012345678901234567890123456789"}, // Date prior to current date
            {"0123456789", (new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), "012345678901234567890123456789012345678901234567891"}, // Invalid description length
            {null, (new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), "01234567890123456789012345678901234567890123456789"}, // null appointmentID
            {"0123456789", null, "01234567890123456789012345678901234567890123456789"}, // null Date
            {"0123456789", (new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), null} // null description
    };

    @Test
    public void TestAddAppointment() { // Verifying that an exception is raised for each invalid input type
        for (Object[] input : invalidConstructors) {
            assertThrows(IllegalArgumentException.class, () -> {
                new Appointment(
                        (String) input[0],
                        (Date) input[1],
                        (String) input[2]);
                });
        }
    }
    
    @Test
    public void TestGetMethods() { // Verifying that all get methods return valid data
        Appointment testAppointment = new Appointment("0123456789", (new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), "01234567890123456789012345678901234567890123456789");
        assertEquals("0123456789", testAppointment.GetAppointmentID());
        assertEquals((new Date((currDate.getYear()+1),(currDate.getMonth()),currDate.getDate())), testAppointment.GetAppointmentDate());
        assertEquals("01234567890123456789012345678901234567890123456789", testAppointment.GetAppointmentDescription());
    }
}