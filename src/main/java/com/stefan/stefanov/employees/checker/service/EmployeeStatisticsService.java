package com.stefan.stefanov.employees.checker.service;

import com.stefan.stefanov.employees.checker.dto.CsvRow;
import com.stefan.stefanov.employees.checker.dto.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeStatisticsService {

    private final CsvRowsProvider<InputStream> csvRowsProvider;

    public List<Result> getResult(InputStream inputStream) {
        List<Result> result = new ArrayList<>();
        List<CsvRow> rows = csvRowsProvider.getRecords(inputStream);

        for (int i = 0; i < rows.size(); i++) {
            CsvRow row = rows.get(i);
            for (int j = i + 1; j < rows.size(); j++) {
                CsvRow nextRow = rows.get(j);
                if (nextRow.getProjectId() != row.getProjectId()) {
                    continue;
                }
                if (nextRow.getEmpId() == row.getEmpId()) {
                    continue;

                }
                long overlapDays = getOverlapDays(nextRow, row);
                if (overlapDays == 0) {
                    continue;
                }

                Result r = new Result(nextRow.getEmpId(), row.getEmpId(), row.getProjectId(), overlapDays);
                result.add(r);
            }
        }

        final long maxDays = result.stream()
                .mapToLong(Result::getLengthDays)
                .max()
                .orElse(0);

        return result.stream()
                .filter(r -> r.getLengthDays() == maxDays)
                .collect(Collectors.toList());
    }

    private long getOverlapDays(CsvRow csvRow1, CsvRow csvRow2) {
        return getOverlapDays(csvRow1.getDateFrom(), csvRow1.getDateTo(), csvRow2.getDateFrom(), csvRow2.getDateTo());
    }

    private boolean doIntervalsOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !end1.isBefore(start2) && !end2.isBefore(start1);
    }

    private long getOverlapDays(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        if (!doIntervalsOverlap(start1, end1, start2, end2)) {
            return 0;
        }
        LocalDate overlapStart = start1.isAfter(start2) ? start1 : start2;
        LocalDate overlapEnd = end1.isBefore(end2) ? end1 : end2;
        return (ChronoUnit.DAYS.between(overlapStart, overlapEnd) + 1);
    }
}
