package application.models;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * The SetOfAllNamesOfMeterReadingImpl class represents a set of names of meter readings.
 * It implements the SetOfAllNamesOfMeterReading interface and provides methods to add meter readings
 * individually or as a set, and to retrieve the list of names of meter readings.
 */
public class SetOfAllNamesOfMeterReadingImpl implements SetOfAllNamesOfMeterReading {

    private Set<String> listOfNamesOfMeterReadings;

    /**
     * Constructs a new SetOfAllNamesOfMeterReadingImpl with an initial list of names.
     *
     * @param listOfNamesOfMeterReadings The initial list of names of meter readings.
     */
    public SetOfAllNamesOfMeterReadingImpl(LinkedHashSet<String> listOfNamesOfMeterReadings) {
        this.listOfNamesOfMeterReadings = listOfNamesOfMeterReadings;
    }

    /**
     * Constructs a new SetOfAllNamesOfMeterReadingImpl with an empty list of names.
     */
    public SetOfAllNamesOfMeterReadingImpl() {
        listOfNamesOfMeterReadings = new LinkedHashSet<>();
    }

    /**
     * Adds a meter reading to the set of names.
     *
     * @param meterReading The name of the meter reading to be added.
     */
    public void addMeterReading(String meterReading) {
        if (!meterReading.isEmpty()) {
            listOfNamesOfMeterReadings.add(meterReading);
        } else {
            System.out.println("Incorrect argument");
        }
    }

    /**
     * Adds a set of additional meter readings to the set of names.
     *
     * @param listOfAdditionalMeterReadings The set of additional meter readings to be added.
     */
    public void addMeterReading(LinkedHashSet<String> listOfAdditionalMeterReadings) {
        if (!listOfAdditionalMeterReadings.isEmpty()) {
            this.listOfNamesOfMeterReadings = listOfAdditionalMeterReadings;
        } else {
            System.out.println("List of extra meter readings is empty");
        }
    }

    /**
     * Gets the list of names of meter readings.
     *
     * @return The set of names of meter readings.
     */
    public Set<String> getListOfNamesOfMeterReadings() {
        return listOfNamesOfMeterReadings;
    }
}
