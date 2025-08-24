package TaskServiceTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TaskService.TaskService;
import TaskService.Task;

public class TaskServiceTest {

    @Test
    public void TestAddTask() { // Verifying that when a task is added that the task object contains the right variables
        TaskService testTaskService = new TaskService();
        String taskID = testTaskService.AddTask("Task name", "Task description");
        assertEquals("Task name", testTaskService.tasks.get(taskID).GetTaskName());
        assertEquals("Task description", testTaskService.tasks.get(taskID).GetTaskDescription());
    }
    
    @Test
    public void TestCheckForID() { // Verifying that if taskID is not in hashmap a exception is thrown
    	TaskService testTaskService = new TaskService();
    	assertThrows(IllegalArgumentException.class, () -> {testTaskService.CheckForID("-1");});
    }

    @Test
    public void TestDeleteTask() { // Verifying that once a created task is deleted that the object is removed from hashmap
    	TaskService testTaskService = new TaskService();
        String taskID = testTaskService.AddTask("Task name", "Task description");
        testTaskService.DeleteTask(taskID);
        assertTrue(testTaskService.tasks.isEmpty());
    }
    

    @Test
    public void TestUpdateFields() { // Verifying that the updated methods do not thrown an exception and then that the new updated values are correctly stored in object fields
    	TaskService testTaskService = new TaskService();
    	String taskID = testTaskService.AddTask("Test name", "Task Description");
    	assertDoesNotThrow(() -> {testTaskService.UpdateTaskName(taskID, "NameTest");});
    	assertDoesNotThrow(() -> {testTaskService.updateTaskDescription(taskID, "DescriptionTask");});
    	
    	Task testTask = testTaskService.tasks.get(taskID);
    	assertEquals("NameTest", testTask.GetTaskName());
    	assertEquals("DescriptionTask", testTask.GetTaskDescription());
    }
}