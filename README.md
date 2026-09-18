# Contact, Task, and Appointment Services — Java Unit Testing

> **Status:** Integrated CS 320 academic project and the canonical repository for the three service milestones. The implementation and JUnit tests are present; a fresh test run is still required, and one appointment-service test currently exercises the wrong service.

This project implements three small Java services backed by in-memory <code>HashMap</code> collections. Each domain object enforces assignment-defined input limits, and the associated JUnit 5 classes test constructors, getters, and service operations. The work focuses on translating requirements into validation rules and tests rather than building a persistent or networked application.

## Services and test coverage in source

| Service | Implemented rules and operations | Corresponding tests |
| --- | --- | --- |
| Contact | ID, first name, last name, and phone fields limited to 10 characters; address limited to 30; add, delete, and update operations | <code>ContactTest</code> and <code>ContactServiceTest</code> |
| Task | ID limited to 10 characters, name to 20, and description to 50; add, delete, and update operations | <code>TaskTest</code> and <code>TaskServiceTest</code> |
| Appointment | ID limited to 10 characters, date cannot be null or in the past, and description limited to 50; add and delete operations | <code>AppointmentTest</code> and <code>AppointmentServiceTest</code> |

The source and tests are under [ProjectOne/src](./ProjectOne/src). IDs are generated within each in-memory service; data does not persist after the process ends. This repository does not implement an HTTP layer, database, user authentication, or a comprehensive software-security program.

## Running the tests

The Maven project is [ProjectOne/pom.xml](./ProjectOne/pom.xml). From the repository root, the intended command is:

```powershell
mvn -f .\ProjectOne\pom.xml test
```

This command was not verified during the documentation audit because Maven was unavailable in the audit environment. The POM declares JUnit Jupiter 5.11.0 but leaves the Java compiler and Surefire plugin versions implicit, so a fresh environment should confirm compilation and test discovery. Checked-in <code>target</code> reports are historical build artifacts, not evidence of a current run.

## Known test limitation

<code>AppointmentServiceTest.TestIDCheck</code> creates a <code>ContactService</code> and tests its invalid-ID behavior. Until that test is corrected to exercise <code>AppointmentService</code>, the suite should not be described as complete appointment-service coverage. The other appointment tests cover object validation, getters, adding, and deleting appointments.

## Course artifacts

- [Project Two testing report](./Project%20Two_Michael_Foster.docx) — historical analysis submitted for the course
- [Contact-service milestone](https://github.com/mf0zz13-SNHU-School-Work/CS-320-Milestone-Contact-Service)
- [Task-service milestone](https://github.com/mf0zz13-SNHU-School-Work/CS-320-Milestone-Task-Service)
- [Appointment-service milestone](https://github.com/mf0zz13/CS-320-Milestone-Appointment-Service)

<details>
<summary>Course reflection</summary>

### How can I ensure that my code, program, or software is functional and secure?

Testing is one part of establishing that software behaves as intended and handles invalid input, but testing alone cannot prove that a system is secure. I use requirements to design positive and negative test cases, then combine those results with validation, code review, dependency review, and secure design decisions. Functional tests check observable behavior; nonfunctional testing can examine qualities such as performance and reliability.

### How do I interpret user needs and incorporate them into a program?

I begin by clarifying the result the user needs and translating it into specific, testable requirements. Those requirements guide both the implementation and its test cases. Connecting each test to a requirement makes gaps and ambiguous behavior easier to find before the software is considered complete.

### How do I approach designing software?

I start with the desired end state, identify the domain rules, and turn them into small responsibilities and test cases. I then implement enough behavior to satisfy those cases, review the result against the original requirements, and refactor when the evidence shows a clearer design is possible.

</details>
