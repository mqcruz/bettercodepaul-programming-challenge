package de.bcxp.challenge;

import de.bcxp.challenge.model.Weather;
import de.bcxp.challenge.service.CsvFileReaderService;
import de.bcxp.challenge.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeatherServiceTest {
    @Test
    void testGetSmallestTempSpreadDay() {
        CsvFileReaderService mockReaderService = Mockito.mock(CsvFileReaderService.class);
        List<Weather> weatherData = List.of(
                new Weather(1, 30, 15),
                new Weather(2, 20, 10)
        );
        Mockito.when(mockReaderService.readData(Mockito.anyString())).thenReturn(weatherData);

        assertEquals(2, WeatherService.getSmallestTempSpreadDay(weatherData));
    }

    @Test
    void testGetSmallestTempSpreadDayEmptyList() {
        assertThrows(NoSuchElementException.class, () -> WeatherService.getSmallestTempSpreadDay(Collections.emptyList()));
    }
}