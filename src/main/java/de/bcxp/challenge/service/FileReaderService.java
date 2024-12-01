package de.bcxp.challenge.service;

import java.util.List;

/**
 * The {@code FileReaderService} interface defines a contract for reading data from files.
 * It provides a method to read and parse data from a file located at a specified path,
 * returning a list of objects of type {@code T}.
 *
 * @param <T> the type of objects that the data will be parsed into
 */
public interface FileReaderService<T> {
    /**
     * Reads data from a file specified by the given file path and converts it into a list of objects of type {@code T}.
     *
     * @param filePath the path to the file to read data from
     * @return a {@code List} of objects of type {@code T} containing the parsed data
     */
    List<T> readData(String filePath);
}