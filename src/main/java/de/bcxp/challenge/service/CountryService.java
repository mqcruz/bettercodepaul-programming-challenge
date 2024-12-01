package de.bcxp.challenge.service;

import de.bcxp.challenge.model.Country;

import java.util.Comparator;
import java.util.List;

public class CountryService {

    private final List<Country> countryList;

    public CountryService(CsvFileReaderService csvFileReaderService) {
        String filePath = "src/main/resources/de/bcxp/challenge/countries.csv";
        countryList = csvFileReaderService.readData(filePath);

    }
    public String getHighestPopulationDensityCountry() {
        return this.countryList.stream().max(Comparator.comparingDouble(Country::getPopulationDensity)).orElseThrow().getName();
    }
}
