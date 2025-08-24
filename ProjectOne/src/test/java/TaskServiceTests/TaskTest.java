package TaskServiceTests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TaskService.Task;

public class TaskTest {

	private Object[][] invalidConstructors = {
			{"012345678911", "task name", "task description field"}, //Task id too long
            {"01234567891", "012345678901234567891", "task description field"}, // Task name too long
            {"01234567891", "task name", "012345678901234567890123456789012345678901234567890"}, // Task description too long
            {null, "task name", "task description field"}, //Task id null
            {"01234567891", null, "task description field"}, // Task name null
            {"01234567891", "task name", null} // Task description null
	};
	
	@Test
	public void TestAddTask() {
		for (Object[] input: invalidConstructors) {
			assertThrows(IllegalArgumentException.class, () -> { // Verifying exception thrown for each invalid constructor
				new Task(
						(String) input[0],
						(String) input[1],
						(String) input[2]);
			});
		}
		
		assertDoesNotThrow(() -> { // Verifying exception not thrown for valid constructor
			new Task(
				"0123456789",
				"task name",
				"task description field");
		});	
	}
	
    @Test
    public void TestGetMethods() { // Verifying get methods return correct values
      Task testTask = new Task("0123456789", "test name field", "test description field");
      assertEquals("0123456789", testTask.GetTaskID());
      assertEquals("test name field",testTask.GetTaskName());
      assertEquals("test description field", testTask.GetTaskDescription());
    }
}