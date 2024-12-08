/**
 * Name: Lingpeng Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: LegacyCustomer.java
 * Description: This class represents a legacy customer in the old system.
 */
package edu.bu.met.cs665;
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
