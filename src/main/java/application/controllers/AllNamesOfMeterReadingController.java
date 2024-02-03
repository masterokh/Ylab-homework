package application.controllers;

import application.dto.AbstractUserFullDTO;

import java.util.Set;

/**
 * Interface defining the input port for managing all names of meter readings.
 * Acts as a boundary between the application's business logic and user interactions.
 */
public interface AllNamesOfMeterReadingController {

    /**
     * Adds a new meter reading to the set of all names for admin users.
     *
     * @param abstractUserFullDTO The user for whom the meter reading is being added.
     * @param newMeterReading      The name of the new meter reading.
     */
    void addMeterReading(AbstractUserFullDTO abstractUserFullDTO, String newMeterReading);

    /**
     * Retrieves the set of all names of meter readings.
     *
     * @return A set containing all names of meter readings in the system.
     */
    Set<String> getListOfNamesOfMeterReadings();
}
