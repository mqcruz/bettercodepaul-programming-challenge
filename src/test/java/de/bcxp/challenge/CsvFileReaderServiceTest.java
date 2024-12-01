package de.bcxp.challenge;

import de.bcxp.challenge.model.Country;
import de.bcxp.challenge.model.Weather;
import de.bcxp.challenge.service.CsvFileReaderService;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvFileReaderServiceTest {

    @Test
    void testReadDataValidFile() {
        String filePath = "src/test/resources/success/countries.csv";

        CsvFileReaderService<Country> csvReaderService = new CsvFileReaderService<>( ";");
        List<Country> results = csvReaderService.readData(filePath);

        assertEquals(1, results.size());
        assertEquals("Austria", results.get(0).getName());
    }

    @Test
    void testReadDataFileNotFound() {
        String filePath = "src/test/resources/countries2.csv";

        CsvFileReaderService<Country> csvReaderService = new CsvFileReaderService<>( ";");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> csvReaderService.readData(filePath));
        assertTrue(exception.getMessage().contains("File not found - fileName: countries2.csv"));
    }

    @Test
    void testReadDataHeaderNotFound() {
        String filePath = "src/test/resources/failure/countries.csv";

        CsvFileReaderService<Country> csvReaderService = new CsvFileReaderService<>( ";");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> csvReaderService.readData(filePath));
        assertTrue(exception.getMessage().contains("Header line cannot be empty"));
    }

    @Test
    void testReadingDataFailure() {
        String filePath = "nothing/test/resources/failure/countries.csv";

        CsvFileReaderService<Weather> csvReaderService = new CsvFileReaderService<>( ";");
        RuntimeException exception = assertThrows(RuntimeException.class, () -> csvReaderService.readData(filePath));
        assertTrue(exception.getMessage().contains("Error reading data from file"));
    }
}