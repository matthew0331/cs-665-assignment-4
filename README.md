| CS-665       | Software Design & Patterns |
|--------------|----------------------------|
| Name         | Lingpeng Li                |
| Date         | 12/08/2024                 |
| Course       | Fall 2024                  |
| Assignment # | 6                          |


---
## GitHub Repository Link:
---
https://github.com/matthew0331/cs-665-assignment-6
---

---

## Description
This project integrates a legacy customer data system, which uses binary files via a USB connection, with a new system that accesses customer data through a REST API over HTTPS. The integration is achieved using the Adapter Design Pattern, with a focus on refactoring the implementation to simplify adapter logic, enhance abstraction, improve encapsulation, and increase test coverage.

## Improvements Made

### **1. Simplified Adapter Logic**

#### **Issue**
The original adapter had unnecessary complexity in combining fields and lacked reusable methods, resulting in redundant code and lower readability.

#### **Changes**
- Directly combined fields such as `firstName` and `lastName` using string concatenation.
- Extracted repeated logic into a private helper method `formatContactDetails`.

#### **Code Example**
```java
public class CustomerAdapter implements NewCustomerInterface {
    private final LegacyCustomer legacyCustomer;

    public CustomerAdapter(LegacyCustomer legacyCustomer) {
        this.legacyCustomer = legacyCustomer;
    }

    @Override
    public String getFullName() {
        return legacyCustomer.getFirstName() + " " + legacyCustomer.getLastName();
    }

    @Override
    public String getContactDetails() {
        return formatContactDetails(legacyCustomer.getPhone(), legacyCustomer.getEmail());
    }

    private String formatContactDetails(String phone, String email) {
        return String.format("Phone: %s, Email: %s", phone, email);
    }
}
```

#### **Reason**
- Extracting reusable logic improves maintainability by reducing redundancy.
- Makes the code more readable and easier to modify.

#### **Advantages**
- Reduced redundancy by reusing the `formatContactDetails` method.
- Enhanced readability and maintainability for future changes.

---

### **2. Introduced Abstraction**

#### **Issue**
Lack of abstraction in the original code made it harder to extend functionality and maintain separation of concerns.

#### **Changes**
- Introduced a `NewCustomerInterface` that defines methods `getFullName` and `getContactDetails`.
- Implemented this interface in the `CustomerAdapter`.

#### **Code Example**
```java
public interface NewCustomerInterface {
    String getFullName();
    String getContactDetails();
}

public class CustomerAdapter implements NewCustomerInterface {
    private final LegacyCustomer legacyCustomer;

    public CustomerAdapter(LegacyCustomer legacyCustomer) {
        this.legacyCustomer = legacyCustomer;
    }

    @Override
    public String getFullName() {
        return legacyCustomer.getFirstName() + " " + legacyCustomer.getLastName();
    }

    @Override
    public String getContactDetails() {
        return formatContactDetails(legacyCustomer.getPhone(), legacyCustomer.getEmail());
    }
}
```

#### **Reason**
- Abstraction ensures that future adapters can implement the same interface without changing existing code.
- Follows the **Open/Closed Principle**, making the system open for extension but closed for modification.

#### **Advantages**
- Improved scalability by allowing the addition of new adapters without modifying the existing code.
- Clear separation of concerns improves modularity.

---

### **3. Enhanced Testing Coverage**

#### **Issue**
The original project lacked sufficient test cases to handle edge scenarios such as null values, empty fields, and mixed data.

#### **Changes**
- Added 5 JUnit test cases, including:
    - Normal use cases.
    - Edge cases like null fields.
    - Empty values in `phone` or `email`.

#### **Code Example**
```java
@Test
public void testFullNameWithEmptyLastName() {
    LegacyCustomer customer = new LegacyCustomer("Emily", "", "123456789", "emily@example.com");
    CustomerAdapter adapter = new CustomerAdapter(customer);
    assertEquals("Emily ", adapter.getFullName());
}

@Test
public void testAdapterForNullFields() {
    LegacyCustomer customer = new LegacyCustomer(null, "Taylor", null, null);
    CustomerAdapter adapter = new CustomerAdapter(customer);
    assertEquals("null Taylor", adapter.getFullName());
    assertEquals("Phone: null, Email: null", adapter.getContactDetails());
}
```

#### **Reason**
- Testing ensures that all possible inputs are validated and handled gracefully.
- Avoids runtime errors or unexpected behaviors.

#### **Advantages**
- Higher reliability by covering edge cases.
- Detects potential bugs early in development.

---

### **4. Improved Encapsulation**

#### **Issue**
Some fields in `LegacyCustomer` were directly accessible, violating encapsulation and potentially compromising data integrity.

#### **Changes**
- All fields were made private.
- Added getter methods for controlled access.

#### **Code Example**
```java
public class LegacyCustomer {
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    public LegacyCustomer(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}
```

#### **Reason**
- Protects class fields from being modified directly.
- Ensures controlled access to data, maintaining integrity.

#### **Advantages**
- Enhances security and reliability of data.
- Aligns with object-oriented design principles.

---

### **5. Added a Demonstrative Main Class**

#### **Issue**
The original project lacked a `Main.java` to demonstrate how the adapter works with sample data.

#### **Changes**
- Created `Main.java` to showcase how `CustomerAdapter` adapts `LegacyCustomer` to `NewCustomerInterface`.

#### **Code Example**
```java
public class Main {
    public static void main(String[] args) {
        LegacyCustomer legacyCustomer = new LegacyCustomer("Alice", "Johnson", "555-1234", "alice@example.com");
        CustomerAdapter adapter = new CustomerAdapter(legacyCustomer);

        System.out.println("Full Name: " + adapter.getFullName());
        System.out.println("Contact Details: " + adapter.getContactDetails());
    }
}
```

#### **Reason**
- Provides a clear example of how to use the adapter, aiding usability.

#### **Advantages**
- Demonstrates the functionality in a user-friendly manner.
- Serves as a quick validation of the implemented logic.

---

## **UML Diagram**

The UML diagram reflects the following relationships:
1. **LegacyCustomer**:
    - Represents the old system's customer data.
2. **NewCustomerInterface**:
    - Defines methods for the new system.
3. **CustomerAdapter**:
    - Implements `NewCustomerInterface` and adapts `LegacyCustomer` to the new system.
4. **Main**:
    - Demonstrates the use of the adapter.

---

### **Design Pattern Used: Adapter Pattern**
- **Description**:
  The Adapter Pattern bridges the gap between two incompatible interfaces, allowing objects from a legacy system (`LegacyCustomer`) to interact with a new system interface (`NewCustomerInterface`).
- **Implementation**:
    - The `CustomerAdapter` acts as the bridge, implementing the new interface and internally adapting data from the legacy system.
    - This ensures smooth integration without altering existing systems.

### **Advantages of the Pattern**:
1. Enables reusability of existing code.
2. Provides a clean interface for future extensions.
3. Adheres to the Open/Closed Principle, supporting system scalability.

---
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
│                       ├── LegacyCustomer.java
│                       ├── NewCustomerInterface.java
│                       ├── CustomerAdapter.java
│                       └── Main.java
└── test
    └── java
        └── edu
            └── bu
                └── met
                    └── cs665
                        └── CustomerDataAdapterTest.java
```

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
   mvn exec:java -Dexec.mainClass="edu.bu.met.cs665.Main"
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


