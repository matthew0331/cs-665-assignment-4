
package edu.bu.met.cs665;

/**
 * Adapter class that implements NewCustomerData and uses an instance of LegacyCustomerData
 * to provide data to the new system while interacting with the legacy system.
 */
public class LegacyCustomerDataAdapter implements NewCustomerData {

    private LegacyCustomerData legacyCustomerData;

    public LegacyCustomerDataAdapter(LegacyCustomerData legacyCustomerData) {
        this.legacyCustomerData = legacyCustomerData;
    }

    @Override
    public String getCustomerData() {
        // Adapter method translating to the legacy system's retrieval method
        return legacyCustomerData.retrieveLegacyData();
    }

    @Override
    public void updateCustomerData(String data) {
        // Adapter method translating to the legacy system's save method
        legacyCustomerData.saveLegacyData(data);
    }
}
