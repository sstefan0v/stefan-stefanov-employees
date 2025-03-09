package com.stefan.stefanov.employees.checker.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BasicDateParserTest {

    //  @PostConstruct
    public  void test() {
        List<String> dateStrings = List.of(
                "2024-03-27",      // ISO format
                "07/03/2024",      // dd/MM/yyyy
                "03-07-2024",      // MM-dd-yyyy
//                "March 7, 2024",   // MMMM d, yyyy
//                "07-Mar-2024",     // dd-MMM-yyyy

                "07.03.2024"       // dd.MM.yyyy
        );


        for (String dateString : dateStrings) {
           // LocalDate parsedDate = parseDate(dateString, patterns);
//            System.out.println("Input: " + dateString + " -> Parsed: " + parsedDate);
        }
    }

    @Test
    void getDate() {


    }
}