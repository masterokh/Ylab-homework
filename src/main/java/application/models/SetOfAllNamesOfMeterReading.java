package application.models;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The SetOfAllNamesOfMeterReading interface defines the contract for classes that represent a set
 * of names of meter readings. It includes methods to get the list of names and to add meter readings
 * either individually or as a set.
 */
public interface SetOfAllNamesOfMeterReading {

    /**
     * Gets the set of names of meter readings.
     *
     * @return The set of names of meter readings.
     */
    Set<String> getListOfNamesOfMeterReadings();

    /**
     * Adds a meter reading to the set of names.
     *
     * @param meterReading The name of the meter reading to be added.
     */
    void addMeterReading(String meterReading);

    /**
     * Adds a set of additional meter readings to the set of names.
     *
     * @param listOfAdditionalMeterReadings The set of additional meter readings to be added.
     */
    void addMeterReading(LinkedHashSet<String> listOfAdditionalMeterReadings);
}
