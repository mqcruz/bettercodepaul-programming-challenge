package de.bcxp.challenge;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.Weather;
import de.bcxp.challenge.service.CountryService;
import de.bcxp.challenge.service.CsvFileReaderService;
import de.bcxp.challenge.service.FileReaderService;
import de.bcxp.challenge.service.WeatherService;

import java.util.List;

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

        String countriesFilePath = "src/main/resources/de/bcxp/challenge/countries.csv";
        String weatherFilePath = "src/main/resources/de/bcxp/challenge/weather.csv";

        FileReaderService countryFileReaderService = new CsvFileReaderService(";");
        FileReaderService weatherFileReaderService = new CsvFileReaderService(",");

        List<Country> countryList = countryFileReaderService.readData(countriesFilePath);
        List<Weather> weatherList = weatherFileReaderService.readData(weatherFilePath);


        System.out.printf("Day with smallest temperature spread: %s%n",
                WeatherService.getSmallestTempSpreadDay(weatherList));
        System.out.printf("Country with highest population density: %s%n",
                CountryService.getHighestPopulationDensityCountry(countryList));
    }
}
