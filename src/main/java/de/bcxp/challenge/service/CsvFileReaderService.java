package de.bcxp.challenge.service;

import de.bcxp.challenge.mapper.Mapper;
import de.bcxp.challenge.mapper.MapperRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CsvFileReaderService} class provides functionality to read and parse
 * CSV files. By implementing the {@link FileReaderService} interface, it reads data
 * from a given file path and processes it into a list of type {@code T}.
 *
 * @param <T> The type of object that this service processes from the CSV data.
 */
public class CsvFileReaderService<T> implements FileReaderService<T> {
    private final String delimiter;

    public CsvFileReaderService(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Reads and parses data from a CSV file specified by the file path, converting it into
     * a list of type {@code T}.
     *
     * @param filePath The path to the CSV file to be read.
     * @return A {@link List} of type {@code T} containing the parsed data from the CSV file.
     * @throws RuntimeException if the file cannot be read or the header line is empty.
     */
    @SuppressWarnings("unchecked")
    public List<T> readData(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf("/") +1);
        Mapper<T> mapper = (Mapper<T>) MapperRegistry.getMapper(fileName);

        List<T> results = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = fileReader.readLine();
            if (headerLine == null) {
                throw new RuntimeException("Header line cannot be empty");
            }

            String[] headers = headerLine.split(delimiter);
            String line;

            while ((line = fileReader.readLine()) != null) {
                String[] values = line.split(delimiter);
                results.add(mapper.map(values, headers));
            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading data from file: ", e);
        }
        return results;
    }
}
