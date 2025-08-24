package TaskService;

import java.util.HashMap;

public class TaskService {
    
    public HashMap<String,Task> tasks = new HashMap<String,Task>();

    public String GenerateUniqueID() {
    	String uniqueID = null;
    	
    	do { 
    		uniqueID = Integer.toString((int)((Math.random())*1000000001)); // randomly gen a number and covert to string
    	} while (tasks.containsKey(uniqueID)); // continue until unique value is found
    	
    	return uniqueID;
    }
    
    public Boolean CheckForID(String taskID) { // Check if id is in hashmap
    	if (tasks.containsKey(taskID))
    		return true;
    	else
    		throw new IllegalArgumentException("Invalid input");
    }    
    
    public String AddTask(String taskName, String taskDescription) { // creates a new task and adds to hashmap
            String taskID = GenerateUniqueID();
            Task tempTask = new Task(taskID, taskName, taskDescription); 
            tasks.put(taskID, tempTask);
            return taskID;
    }

    public void DeleteTask(String taskID) { // removes task  from hashmap
        if (CheckForID(taskID));
        	tasks.remove(taskID);
    }

    public void UpdateTaskName(String taskID, String taskName) { // updates name in task object
        if (CheckForID(taskID)) {
        	Task tempTask = tasks.get(taskID);
        	tempTask.SetTaskName(taskName);
        }
    }

    public void updateTaskDescription(String taskID, String taskDescription) { // updates description in task object
       if (CheckForID(taskID)) {
    	   Task tempTask = tasks.get(taskID);
    	   tempTask.SetTaskDescription(taskDescription);
       }
    }
}