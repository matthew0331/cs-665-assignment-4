
package edu.bu.met.cs665;

/**
 * Concrete implementation of LegacyCustomerData simulating the legacy system's data handling.
 */
public class LegacyCustomerDataImpl implements LegacyCustomerData {
    private String data = "Initial Legacy Data";

    @Override
    public String retrieveLegacyData() {
        // Simulate data retrieval from a legacy source
        return data;
    }

    @Override
    public void saveLegacyData(String data) {
        // Simulate saving data to a legacy source
        this.data = data;
    }
}
