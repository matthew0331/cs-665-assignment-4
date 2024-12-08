/**
 * Name: Lingpeng Li
 * Course: CS-665 Software Designs & Patterns
 * Date: 12/08/2024
 * File Name: CustomerAdapterTest.java
 * Description: This class tests the functionality of the CustomerAdapter.
 */
package edu.bu.met.cs665;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerDataAdapterTest {
    @Test
    public void testFullName() {
        LegacyCustomer customer = new LegacyCustomer("John", "Doe", "123456789", "john@example.com");
        CustomerAdapter adapter = new CustomerAdapter(customer);
        assertEquals("John Doe", adapter.getFullName());
    }

    @Test
    public void testContactDetailsWithEmptyEmail() {
        LegacyCustomer customer = new LegacyCustomer("Jane", "Smith", "987654321", "");
        CustomerAdapter adapter = new CustomerAdapter(customer);
        assertEquals("Phone: 987654321, Email: ", adapter.getContactDetails());
    }

    @Test
    public void testContactDetailsWithEmptyPhone() {
        LegacyCustomer customer = new LegacyCustomer("Bob", "Brown", "", "bob@example.com");
        CustomerAdapter adapter = new CustomerAdapter(customer);
        assertEquals("Phone: , Email: bob@example.com", adapter.getContactDetails());
    }

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
}
