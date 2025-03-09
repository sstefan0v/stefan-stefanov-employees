package com.stefan.stefanov.employees.checker.service;

import com.stefan.stefanov.employees.checker.exception.DateParseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BasicDateParserTest {

    @InjectMocks
    private BasicDateParser dateParser;

    @Test
    void shouldParseValidDates() {
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("2023-03-15"));
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("15/03/2023"));
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("03-15-2023"));
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("15-Mar-2023"));
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("15-03-2023"));
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("15.03.2023"));
    }

    @Test
    void shouldReturnNullForNullOrEmptyInput() {
        assertNull(dateParser.getDate(null));
        assertNull(dateParser.getDate(""));
        assertNull(dateParser.getDate("null"));
    }

    @Test
    void shouldThrowExceptionForInvalidDateFormats() {
        assertThrows(DateParseException.class, () -> dateParser.getDate("2023/03/15"));
        assertThrows(DateParseException.class, () -> dateParser.getDate("March 15, 2023"));
    }

    @Test
    void shouldThrowExceptionForGarbageInput() {
        Executable executable = () -> dateParser.getDate("abcdefg");
        assertThrows(DateParseException.class, executable);
    }

    @Test
    void shouldHandleLeadingAndTrailingSpaces() {
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate(" 2023-03-15 "));
        assertEquals(LocalDate.of(2023, 3, 15), dateParser.getDate("\t15/03/2023\n"));
    }
}