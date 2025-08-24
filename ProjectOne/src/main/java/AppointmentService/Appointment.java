package AppointmentService;

import java.util.Date;

public class Appointment {
    private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	
	public Appointment(String appointmentID, Date appointmentDate, String appointmentDescription) {
	    SetAppointmentID(appointmentID);
	    SetAppointmentDate(appointmentDate);
	    SetAppointmentDescription(appointmentDescription);
	}
	
	private String ValidateInput(String input,int length) { // Verifies that input is not null and less than passed length
		if(input == null || input.length() > length)
		    throw new IllegalArgumentException("Invalid input");
		return input;
	}
	
	
	private void SetAppointmentID(String appointmentID) {
	    this.appointmentID = ValidateInput(appointmentID, 10);
	}
	public String GetAppointmentID() {
	    return appointmentID;
	}
	   
	
    public void SetAppointmentDate(Date appointmentDate) { 
        Date SystemDate = new Date();
    
        if (appointmentDate == null || appointmentDate.before(SystemDate)) // Verifies that appointment date is not prior to current date
            throw new IllegalArgumentException("Date can not be in the past");
        else
            this.appointmentDate = appointmentDate;
    }
    public Date GetAppointmentDate() {
	    return appointmentDate;
    }
   

    public void SetAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = ValidateInput(appointmentDescription, 50);
    }
    public String GetAppointmentDescription() {
        return appointmentDescription;
    }
}
