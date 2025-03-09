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

    private static final String EMP_ID_HEADER = "EmpID";
    private static final String PROJ_ID_HEADER = "ProjectID";
    private static final String DATE_FROM_HEADER = "DateFrom";
    private static final String DATE_TO_HEADER = "DateTo";

    private final DateParser dateParser;

    public List<CsvRow> parseCsvFile(InputStream inputStream) {
        final List<CsvRow> rows = new ArrayList<>();

        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(EMP_ID_HEADER, PROJ_ID_HEADER, DATE_FROM_HEADER, DATE_TO_HEADER)
                .setSkipHeaderRecord(true)
                .build();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(reader, csvFormat)) {

            for (CSVRecord record : csvParser) {
                log.info("CSV record: {}", record);

                Map<String, String> recordMap = record.toMap();
                LocalDate dateTo = dateParser.getDate(recordMap.get(DATE_TO_HEADER));
                dateTo = dateTo == null ? LocalDate.now() : dateTo;

                CsvRow csvRow = CsvRow.getBuilder()
                        .empId(recordMap.get(EMP_ID_HEADER))
                        .projectId(recordMap.get(PROJ_ID_HEADER))
                        .dateFrom(dateParser.getDate(recordMap.get(DATE_FROM_HEADER)))
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
