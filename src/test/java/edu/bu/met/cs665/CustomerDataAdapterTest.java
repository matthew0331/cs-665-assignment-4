package edu.bu.met.cs665;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * JUnit tests for the adapter pattern implementation that bridges legacy and new customer data systems.
 */
public class CustomerDataAdapterTest {

    @Test
    public void testAdapterRetrievesLegacyData() {
        LegacyCustomerData legacyData = new LegacyCustomerDataImpl();
        NewCustomerData adapter = new LegacyCustomerDataAdapter(legacyData);

        // Verify that the adapter retrieves data using the legacy interface
        assertEquals("Initial Legacy Data", adapter.getCustomerData());
    }

    @Test
    public void testAdapterUpdatesLegacyData() {
        LegacyCustomerData legacyData = new LegacyCustomerDataImpl();
        NewCustomerData adapter = new LegacyCustomerDataAdapter(legacyData);

        // Update data through the adapter and verify in the legacy system
        adapter.updateCustomerData("Updated Legacy Data");
        assertEquals("Updated Legacy Data", legacyData.retrieveLegacyData());
    }

    @Test
    public void testNewSystemRetrievesDataDirectly() {
        NewCustomerData newData = new NewCustomerDataImpl();

        // Direct retrieval from the new system
        assertEquals("Initial New Data", newData.getCustomerData());
    }

    @Test
    public void testNewSystemUpdatesDataDirectly() {
        NewCustomerData newData = new NewCustomerDataImpl();

        // Direct update in the new system
        newData.updateCustomerData("Updated New Data");
        assertEquals("Updated New Data", newData.getCustomerData());
    }

    @Test
    public void testAdapterCompatibility() {
        LegacyCustomerData legacyData = new LegacyCustomerDataImpl();
        NewCustomerData adapter = new LegacyCustomerDataAdapter(legacyData);

        // Ensure adapter works independently of the direct new system
        adapter.updateCustomerData("Adapter Test Compatibility");
        assertNotEquals("Initial New Data", adapter.getCustomerData());
        assertEquals("Adapter Test Compatibility", legacyData.retrieveLegacyData());
    }
}
