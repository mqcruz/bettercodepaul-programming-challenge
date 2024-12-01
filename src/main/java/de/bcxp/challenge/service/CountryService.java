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

    /**
     * Returns the name of the country with the highest population density.
     *
     * @param  countryList a list of countries
     * @return the name of the country with the highest population density
     * @throws NoSuchElementException if there are no countries in the list
     */
    public static String getHighestPopulationDensityCountry(List<Country> countryList) {
        return countryList.stream().max(Comparator.comparingDouble(Country::getPopulationDensity)).orElseThrow().getName();
    }
}
