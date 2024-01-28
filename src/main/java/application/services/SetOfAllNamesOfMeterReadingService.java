package application.services;

import application.dto.AbstractUserFullDTO;
import java.util.Set;

/**
 * The SetOfAllNamesOfMeterReadingService interface defines methods for managing a set of
 * all names of meter readings. It provides functionalities for adding new meter readings
 * and retrieving the current list of names.
 */
public interface SetOfAllNamesOfMeterReadingService {

    /**
     * Adds a new meter reading to the set if the provided user has the necessary permissions.
     *
     * @param abstractUserFullDTO The user attempting to add the meter reading.
     * @param newMeterReading     The new meter reading to be added.
     */
    void addMeterReading(AbstractUserFullDTO abstractUserFullDTO, String newMeterReading);

    /**
     * Retrieves the current list of names of meter readings.
     *
     * @return A set containing names of all meter readings.
     */
    Set<String> getListOfNamesOfMeterReadings();
}
