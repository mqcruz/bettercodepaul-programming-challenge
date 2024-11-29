package de.bcxp.challenge;

import de.bcxp.challenge.service.CountryService;
import de.bcxp.challenge.service.CsvFileReaderService;
import de.bcxp.challenge.service.WeatherService;
/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderService();

        CountryService countryService = new CountryService(csvFileReaderService);
        WeatherService weatherService = new WeatherService(csvFileReaderService);

        System.out.printf("Day with smallest temperature spread: %s%n", weatherService.getSmallestTempSpreadDay());
        System.out.printf("Country with highest population density: %s%n", countryService.getHighestPopulationDensityCountry());
    }
}
