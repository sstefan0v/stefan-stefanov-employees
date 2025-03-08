package com.stefan.stefanov.employees.checker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@Slf4j
public class BasicDateParser implements DateParser {

    private final List<String> patterns = List.of(
            "MMMM d, yyyy",
            "yyyy-MM-dd",
            "dd/MM/yyyy",
            "MM-dd-yyyy",
            "dd-MMM-yyyy",
            "dd-MM-yyyy",
            "dd.MM.yyyy"
    );

    private LocalDate parseDate(String dateStr, List<String> patterns) {
        if (dateStr == null || dateStr.isEmpty() || dateStr.trim().equalsIgnoreCase("null")) {
            return null;
        }
        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                return LocalDate.parse(dateStr.trim(), formatter);
            } catch (DateTimeParseException exc) {
                log.debug("Invalid date format: {}, {}", dateStr, exc.toString());
            }
        }
        throw new IllegalArgumentException("Invalid date format: " + dateStr);
    }

    @Override
    public LocalDate getDate(String dateString) {
        return parseDate(dateString, patterns);
    }
}
