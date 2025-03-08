package com.stefan.stefanov.employees.checker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stefan.stefanov.employees.checker.service.EmployeeStatisticsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequiredArgsConstructor
public class FilesController {

    private final EmployeeStatisticsService employeeStatisticsService;

    private final ObjectMapper objectMapper;

    @PostMapping("/employees")
    public ResponseEntity<String> receiveFile(HttpServletRequest request) throws IOException {

        final Object r =    employeeStatisticsService.getResult(request.getInputStream());

        return ResponseEntity.ok(objectMapper.writeValueAsString(r));
    }
}
