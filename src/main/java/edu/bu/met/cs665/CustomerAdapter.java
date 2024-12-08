/**
 * Name: Lingpeng Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: CustomerAdapter.java
 * Description: This class adapts the LegacyCustomer to the NewCustomerInterface.
 */
package edu.bu.met.cs665;
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
