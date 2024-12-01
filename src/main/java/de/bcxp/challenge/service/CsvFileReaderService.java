package de.bcxp.challenge.service;

import de.bcxp.challenge.mapper.Mapper;
import de.bcxp.challenge.mapper.MapperRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderService<T> implements FileReaderService<T> {
    private final String delimiter;

    public CsvFileReaderService(String delimiter) {
        this.delimiter = delimiter;
    }

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
