package AppointmentService;

import java.util.Date;
import java.util.HashMap;

public class AppointmentService {
    public HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
    
    private String GenerateUniqueID() { 
    	String uniqueID = null;
    	
    	do {
    		uniqueID = Integer.toString((int)((Math.random())*1000000001)); // generates a random number and converts to string
    	} while (appointments.containsKey(uniqueID)); // continues until a unique value is found
    	
    	return uniqueID;
    }
    
    public Boolean CheckForID(String uniqueID) { // checks if uniqueID is in hashmap
    	if (appointments.containsKey(uniqueID))
    		return true;
    	else
    		throw new IllegalArgumentException("Contact ID is not valid");
    }
    
    public String AddAppointment(Date appointmentDate, String appointmentDescription) { // creates new appointment object and adds it to hashmap
        String appointmentID = GenerateUniqueID();
        Appointment tempAppointment = new Appointment(appointmentID, appointmentDate, appointmentDescription);
        appointments.put(appointmentID,tempAppointment);
        return appointmentID;
    }

    public void deleteAppointment(String appointmentID) { // removes appointment object form hashmap
      	if (CheckForID(appointmentID))
      		appointments.remove(appointmentID);
    }
}
