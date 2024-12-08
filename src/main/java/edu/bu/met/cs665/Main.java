/**
 * Name: Lingpeng Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: Main.java
 * Description: This is the main class demonstrating the use of the CustomerAdapter.
 */
package edu.bu.met.cs665;
public class Main {
    public static void main(String[] args) {
        // Create a LegacyCustomer instance
        LegacyCustomer legacyCustomer = new LegacyCustomer("Alice", "Johnson", "555-1234", "alice@example.com");

        // Use the CustomerAdapter to adapt the LegacyCustomer to NewCustomerInterface
        CustomerAdapter adapter = new CustomerAdapter(legacyCustomer);

        // Demonstrate the functionality of the adapter
        System.out.println("Full Name: " + adapter.getFullName());
        System.out.println("Contact Details: " + adapter.getContactDetails());
    }
}
