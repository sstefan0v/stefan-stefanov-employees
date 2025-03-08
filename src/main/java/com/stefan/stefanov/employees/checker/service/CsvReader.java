package com.stefan.stefanov.employees.checker.service;

import com.stefan.stefanov.employees.checker.dto.CsvRow;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CsvReader implements CsvRowsProvider<InputStream> {

    private final DateParser dateParser;

    public List<CsvRow> parseCsvFile(InputStream inputStream) {
        List<CsvRow> rows = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord record : csvParser) {

                Map<String, String> recordMap = record.toMap();
                LocalDate dateTo = dateParser.getDate(recordMap.get("DateTo"));
                dateTo = dateTo == null ? LocalDate.now() : dateTo;

                CsvRow csvRow = CsvRow.getBuilder()
                        .empId(recordMap.get("EmpID"))
                        .projectId(recordMap.get("ProjectID"))
                        .dateFrom(dateParser.getDate(recordMap.get("DateFrom")))
                        .dateTo(dateTo)
                        .build();
                rows.add(csvRow);
            }

        } catch (IOException e) {
            log.error("There was ane error: ", e);
        }

        return rows;
    }

    @Override
    public List<CsvRow> getRecords(InputStream inputStream) {
         return parseCsvFile(inputStream);
    }
}
