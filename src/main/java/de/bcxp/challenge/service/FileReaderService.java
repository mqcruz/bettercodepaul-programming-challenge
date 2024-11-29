package de.bcxp.challenge.service;

import java.util.List;

public interface FileReaderService<T> {
    List<T> readData(String resource, String delimiter);
}