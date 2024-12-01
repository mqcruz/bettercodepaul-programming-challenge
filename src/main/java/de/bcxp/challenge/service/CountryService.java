package de.bcxp.challenge.service;

import de.bcxp.challenge.model.Country;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Service class to provide operations related to countries.
 * It reads country data from a file and allows performing operations.
 */
public class CountryService {

    private final List<Country> countryList;

    /**
     * Constructs a new CountryService with the specified FileReaderService.
     * It reads country data from a file located in the resources.
     *
     * @param fileReaderService a service for reading files
     */
    public CountryService(FileReaderService fileReaderService) {
        String filePath = "src/main/resources/de/bcxp/challenge/countries.csv";
        countryList = fileReaderService.readData(filePath);

    }

    /**
     * Returns the name of the country with the highest population density.
     *
     * @return the name of the country with the highest population density
     * @throws NoSuchElementException if there are no countries in the list
     */
    public String getHighestPopulationDensityCountry() {
        return this.countryList.stream().max(Comparator.comparingDouble(Country::getPopulationDensity)).orElseThrow().getName();
    }
}
