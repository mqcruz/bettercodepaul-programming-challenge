package de.bcxp.challenge;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.service.CountryService;
import de.bcxp.challenge.service.CsvFileReaderService;
import de.bcxp.challenge.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CountryServiceTest {

    @Test
    void testGetHighestPopulationDensityCountry() {
        CsvFileReaderService mockReaderService = Mockito.mock(CsvFileReaderService.class);
        List<Country> countries = List.of(
                new Country("Germany", 1000, 10),
                new Country("Portugal", 500, 2)
        );

        assertEquals("Portugal", CountryService.getHighestPopulationDensityCountry(countries));
    }

    @Test
    void testGetHighestPopulationDensityCountryEmptyList() {
        assertThrows(NoSuchElementException.class, () -> CountryService.getHighestPopulationDensityCountry(Collections.emptyList()));

    }
}
