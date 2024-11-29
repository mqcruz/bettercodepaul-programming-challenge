package de.bcxp.challenge.mapper;

public interface Mapper<T> {
    T map(String[] values, String[] fields);
}
