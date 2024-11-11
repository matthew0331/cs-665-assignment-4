
package edu.bu.met.cs665;

/**
 * Concrete implementation of NewCustomerData simulating the new system's data handling.
 */
public class NewCustomerDataImpl implements NewCustomerData {
    private String data = "Initial New Data";

    @Override
    public String getCustomerData() {
        // Simulate data retrieval from the new system
        return data;
    }

    @Override
    public void updateCustomerData(String data) {
        // Simulate updating data in the new system
        this.data = data;
    }
}
