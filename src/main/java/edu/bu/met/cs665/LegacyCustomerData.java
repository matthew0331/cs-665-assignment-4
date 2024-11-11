
package edu.bu.met.cs665;

/**
 * Interface for the legacy system to retrieve and save customer data.
 */
public interface LegacyCustomerData {
    String retrieveLegacyData();
    void saveLegacyData(String data);
}
