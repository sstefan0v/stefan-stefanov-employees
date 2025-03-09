package com.stefan.stefanov.employees.checker.service;

import com.stefan.stefanov.employees.checker.dto.CsvRow;
import com.stefan.stefanov.employees.checker.dto.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.InputStream;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import java.util.List;

@ExtendWith(MockitoExtension.class)
class EmployeeStatisticsServiceTest {

    @Mock
    private CsvRowsProvider<InputStream> csvRowsProviderMock;

    @InjectMocks
    private EmployeeStatisticsService cycleDelayService;

    @Test
    void willReturnOverlappingDaysCorrectly() {
        when(csvRowsProviderMock.getRecords(any())).thenReturn(getDataForTest1());

        List<Result> l = cycleDelayService.getResult(any());
        assertEquals(1, l.size());
        assertEquals(9, l.getFirst().getLengthDays());
    }

    @Test
    void willNotFindOverlappingDays() {
        when(csvRowsProviderMock.getRecords(any())).thenReturn(getDataForTest2());

        List<Result> l = cycleDelayService.getResult(any());
        assertEquals(0, l.size());
    }

    @Test
    void willReturnOverlappingDaysCorrectly3() {
        when(csvRowsProviderMock.getRecords(any())).thenReturn(getDataForTest3());

        List<Result> l = cycleDelayService.getResult(any());
        System.out.println(l);
        assertEquals(3, l.size());
        assertEquals(366, l.getFirst().getLengthDays());
    }

    List<CsvRow> getDataForTest1() {
        CsvRow row1 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2010, 1, 1))
                .dateTo(LocalDate.of(2010, 1, 9))
                .empId("1")
                .projectId("2")
                .build();
        CsvRow row2 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2010, 1, 1))
                .dateTo(LocalDate.of(2010, 1, 9))
                .empId("23")
                .projectId("2")
                .build();
        return List.of(row1, row2);
    }

    List<CsvRow> getDataForTest2() {
        CsvRow row1 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2010, 1, 1))
                .dateTo(LocalDate.of(2010, 1, 9))
                .empId("1")
                .projectId("2")
                .build();
        CsvRow row2 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2011, 1, 1))
                .dateTo(LocalDate.of(2015, 1, 9))
                .empId("23")
                .projectId("2")
                .build();
        return List.of(row1, row2);
    }


    List<CsvRow> getDataForTest3() {
        CsvRow row1 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2010, 1, 1))
                .dateTo(LocalDate.of(2011, 1, 1))
                .empId("1")
                .projectId("2")
                .build();
        CsvRow row2 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2010, 1, 1))
                .dateTo(LocalDate.of(2011, 1, 1))
                .empId("3")
                .projectId("2")
                .build();

        CsvRow row3 = CsvRow.getBuilder()
                .dateFrom(LocalDate.of(2010, 1, 1))
                .dateTo(LocalDate.of(2011, 1, 1))
                .empId("23")
                .projectId("2")
                .build();
        return List.of(row1, row2, row3);
    }
}