package com.stefan.stefanov.employees.checker.service;

import java.time.LocalDate;

public interface DateParser {
    LocalDate getDate(String dateString);
}
