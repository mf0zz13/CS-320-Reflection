package TaskService;

public class Task {

    private String taskID;
    private String taskName;
    private String taskDescription;
    
    public Task(String taskId, String taskName, String taskDescription) {
        SetTaskID(taskId);
        SetTaskName(taskName); 
        SetTaskDescription(taskDescription);
    }

    
    private String ValidateInput(String input, int length) { // validates if input is not null and less than passed length
    	if (input == null || input.length() > length)
    		throw new IllegalArgumentException("Invalid input");
    	else
    		return input;
    }
  
    
    private void SetTaskID(String taskID) {
        this.taskID = ValidateInput(taskID, 10);
    }
    public String GetTaskID() {
        return this.taskID;
    }

    
    public void SetTaskName(String taskName) {
        this.taskName = ValidateInput(taskName, 20);
    }
    public String GetTaskName() {
        return this.taskName;
    }
    

    public void SetTaskDescription(String taskDescription) {
        this.taskDescription = ValidateInput(taskDescription, 50);
    }
    public String GetTaskDescription() {
        return this.taskDescription;
    }
}