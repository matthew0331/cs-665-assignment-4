
| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Lingpeng Li                |
| Date         | 11/10/2024                 |
| Course       | Fall 2024                  |
| Assignment # | 4                          |


---
## GitHub Repository Link:
---
https://github.com/matthew0331/cs-665-assignment-4
---

---


# CS 665 Assignment 4 - Utilizing Legacy Systems

## Project Description

This project aims to integrate a legacy customer data system with a new customer data system using the Adapter Design Pattern. The legacy system retrieves and saves customer data from binary files via a USB connection, while the new system accesses customer data through a secure HTTPS connection using a REST API. The objective of this assignment is to bridge these incompatible interfaces, allowing the new system to interact seamlessly with the legacy system.

## Implementation Details

### Design Pattern Used: Adapter Pattern

For this assignment, the Adapter Design Pattern is an ideal choice. Here’s why:

#### Reason for Choosing the Adapter Pattern
The task involves integrating a legacy system and a new system with different interfaces. Specifically:
- The legacy system retrieves customer data from binary files via a USB connection.
- The new system accesses customer data over HTTPS via a REST API.

The Adapter Pattern allows you to bridge these incompatible interfaces by creating an adapter class that translates requests from one system (the new system's API) to the other (the legacy system’s API). This pattern is commonly used when two classes (or systems) cannot work together directly due to interface incompatibility, which aligns perfectly with this task.

#### Benefits of the Adapter Pattern for this Assignment
- **Flexibility**: The Adapter Pattern enables easy integration of both systems without altering their existing code.
- **Extensibility**: Future changes or integrations with other systems can be accommodated by adding new adapters.
- **Maintainability**: The pattern promotes clean and modular code by separating the legacy system's implementation from the new system’s interface.

### How the Pattern Was Used

In this implementation:
- The `LegacyCustomerDataAdapter` class acts as an intermediary between the new and legacy systems.
- The adapter implements the `NewCustomerData` interface but internally relies on an instance of `LegacyCustomerData` to fulfill requests.
- When the new system calls `getCustomerData()` or `updateCustomerData()` on the adapter, these calls are translated to the legacy system’s `retrieveLegacyData()` and `saveLegacyData()` methods, respectively.

This setup allows the new system to retrieve and update data seamlessly through the adapter, without needing to know about the legacy system's specific methods or data formats. By using this pattern, the adapter encapsulates all interactions with the legacy system, ensuring a clean and isolated bridge.



### Flexibility

The implementation of the customer data integration is highly flexible due to the use of the Adapter Pattern. This pattern allows the two systems to work together seamlessly without modifying their existing code. Future customer data systems or legacy systems can be integrated by creating additional adapters, making this solution extensible and adaptable.

### Simplicity and Understandability

The Adapter Pattern simplifies the integration of the legacy and new systems by providing a clear and consistent interface for interaction. The adapter class (`LegacyCustomerDataAdapter`) serves as a bridge, enabling the new system to use legacy data operations without being aware of the underlying complexity. This separation of concerns makes the codebase easy to understand, maintain, and extend by anyone in the future to develop.

### Avoidance of Code Duplication

Code duplication is minimized by centralizing the translation logic within the adapter class. Instead of writing separate methods to handle interactions between the legacy and new systems in various places, the adapter class handles all such translations. This approach ensures that the integration logic is encapsulated in one place, reducing redundancy and enhancing maintainability.


### Source Structure

The project structure follows a logical organization of interfaces, implementations, and tests:

```
src
├── main
│   └── java
│       └── edu
│           └── bu
│               └── met
│                   └── cs665
│                       ├── LegacyCustomerData.java
│                       ├── NewCustomerData.java
│                       ├── LegacyCustomerDataAdapter.java
│                       ├── LegacyCustomerDataImpl.java
│                       ├── NewCustomerDataImpl.java
│                       └── Main.java
└── test
    └── java
        └── edu
            └── bu
                └── met
                    └── cs665
                        └── CustomerDataAdapterTest.java
```

### Explanation of Features

- **Adapter Pattern Use**: The Adapter Pattern allows the new system to interact with the legacy system without modifying either system. This approach encapsulates the incompatibility between the two systems and offers a flexible and maintainable solution.
- **Mock Objects**: Mock implementations for customer data enable testing without relying on actual external connections, ensuring the solution can be tested in isolation.
- **JUnit Testing**: Comprehensive tests ensure that the adapter works correctly, bridging data retrieval and updates between the legacy and new systems. This verifies the robustness of the adapter and confirms that the legacy system is accessible through the new system’s interface.

## Conclusion

The Adapter Pattern is an ideal choice for this assignment as it effectively bridges the gap between the legacy and new systems without altering their internal implementations. By using this pattern, I achieve compatibility, maintainability, and flexibility. The project demonstrates how the Adapter Pattern can integrate incompatible interfaces while maintaining a clean and organized code structure.


## Compilation & Execution

### Prerequisites
- **Java JDK 1.8**
- **Apache Maven** 4.0.0



---

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line:

```bash
mvn clean compile 
```

**Run the Project:**
After compiling, you can run the project by executing the `Main.java` class:
   ``` bash
   mvn exec:java -Dexec.mainClass="edu.bu.met.cs665.Main
   ```

## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```
---

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.



## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`


