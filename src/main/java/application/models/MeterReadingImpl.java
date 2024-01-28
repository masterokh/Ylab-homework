package application.models;

import java.util.HashMap;
import java.util.Map;

/**
 * The MeterReadingImpl class represents an implementation of the MeterReading interface.
 * It stores meter readings for a specific month and year.
 */
public class MeterReadingImpl implements MeterReading {

    private int month;
    private int year;
    private Map<String, Double> readings;

    /**
     * Constructs a new MeterReadingImpl with the specified month and year.
     *
     * @param month The month for which the meter readings are recorded.
     * @param year  The year for which the meter readings are recorded.
     */
    public MeterReadingImpl(int month, int year) {
        this.month = month;
        this.year = year;
        readings = new HashMap<>();
    }

    /**
     * Adds a meter reading for a specific type.
     *
     * @param type  The type of the meter reading (e.g., electricity, water).
     * @param value The value of the meter reading.
     */
    public void addReading(String type, double value) {
        this.readings.put(type, value);
    }

    /**
     * Gets the month for which the meter readings are recorded.
     *
     * @return The month.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the year for which the meter readings are recorded.
     *
     * @return The year.
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets the map of meter readings, where the key is the type and the value is the reading value.
     *
     * @return The map of meter readings.
     */
    public Map<String, Double> getReadings() {
        return readings;
    }
}
