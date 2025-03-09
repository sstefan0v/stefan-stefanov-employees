package com.stefan.stefanov.employees.checker.service;

import com.stefan.stefanov.employees.checker.exception.DateParseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class BasicDateParser implements DateParser {
    private final List<String> patterns = List.of(
            "yyyy-MM-dd",
            "dd/MM/yyyy",
            "MM-dd-yyyy",
            "dd-MMM-yyyy",
            "dd-MM-yyyy",
            "dd.MM.yyyy",
            "dd.MM.yy"
    );

    private LocalDate parseDate(String dateStr, List<String> patterns) {
        if (dateStr == null || dateStr.isEmpty() || dateStr.trim().equalsIgnoreCase("null")) {
            return null;
        }
        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
                return LocalDate.parse(dateStr.trim(), formatter);
            } catch (DateTimeException exc) {
                log.debug("Invalid date format: {}, {}", dateStr, exc.toString());
            }
        }
        throw new DateParseException("String cannot be parsed to date! Invalid date format: " + dateStr);
    }

    @Override
    public LocalDate getDate(String dateString) {
        return parseDate(dateString, patterns);
    }
}
