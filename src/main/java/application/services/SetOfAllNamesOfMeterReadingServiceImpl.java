package application.services;

import application.dto.AbstractUserFullDTO;
import application.dto.AdminFullDTO;
import application.models.SetOfAllNamesOfMeterReadingImpl;
import java.util.Set;

/**
 * The SetOfAllNamesOfMeterReadingServiceImpl class provides a service for managing a set of
 * all names of meter readings. It allows admins to add new meter readings to the set and retrieve
 * the current list of names.
 */
public class SetOfAllNamesOfMeterReadingServiceImpl implements SetOfAllNamesOfMeterReadingService {

    private SetOfAllNamesOfMeterReadingImpl setOfAllNamesOfMeterReadingImpl;

    /**
     * Constructs a SetOfAllNamesOfMeterReadingServiceImpl with an empty set of meter readings.
     */
    public SetOfAllNamesOfMeterReadingServiceImpl() {
        setOfAllNamesOfMeterReadingImpl = new SetOfAllNamesOfMeterReadingImpl();
    }

    /**
     * Adds a new meter reading to the set if the provided user is an admin.
     *
     * @param abstractUserFullDTO The user attempting to add the meter reading.
     * @param newMeterReading     The new meter reading to be added.
     */
    public void addMeterReading(AbstractUserFullDTO abstractUserFullDTO, String newMeterReading) {
        if (abstractUserFullDTO instanceof AdminFullDTO) {
            setOfAllNamesOfMeterReadingImpl.addMeterReading(newMeterReading);
        }
    }

    /**
     * Retrieves the current list of names of meter readings.
     *
     * @return A set containing names of all meter readings.
     */
    public Set<String> getListOfNamesOfMeterReadings() {
        return setOfAllNamesOfMeterReadingImpl.getListOfNamesOfMeterReadings();
    }
}
