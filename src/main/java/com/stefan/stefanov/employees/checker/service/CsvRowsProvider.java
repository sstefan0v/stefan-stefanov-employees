package com.stefan.stefanov.employees.checker.service;

import com.stefan.stefanov.employees.checker.dto.CsvRow;

import java.util.List;

public interface CsvRowsProvider<T> {
    List<CsvRow> getRecords(T source);
}
