package application.models;

import java.util.Map;

/**
 * The MeterReading interface defines the contract for classes that represent meter readings.
 * It includes methods to get the month, year, and readings, as well as a method to add a new reading.
 */
public interface MeterReading {

    /**
     * Gets the month for which the meter readings are recorded.
     *
     * @return The month.
     */
    int getMonth();

    /**
     * Gets the year for which the meter readings are recorded.
     *
     * @return The year.
     */
    int getYear();

    /**
     * Gets the map of meter readings, where the key is the type and the value is the reading value.
     *
     * @return The map of meter readings.
     */
    Map<String, Double> getReadings();

    /**
     * Adds a meter reading for a specific type.
     *
     * @param type  The type of the meter reading (e.g., electricity, water).
     * @param value The value of the meter reading.
     */
    void addReading(String type, double value);
}
