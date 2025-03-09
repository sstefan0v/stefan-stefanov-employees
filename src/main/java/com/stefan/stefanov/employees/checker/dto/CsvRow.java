package com.stefan.stefanov.employees.checker.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CsvRow {

    private int empId;
    private int projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    private CsvRow(Builder builder) {
        this.empId = builder.empId;
        this.projectId = builder.projectId;
        this.dateFrom = builder.dateFrom;
        this.dateTo = builder.dateTo;
    }

    public static class Builder {
        private int empId;
        private int projectId;
        private LocalDate dateFrom;
        private LocalDate dateTo;

        public Builder empId(String empId) {
            this.empId = Integer.parseInt(empId.trim());
            return this;
        }

        public Builder projectId(String projectId) {
            this.projectId = Integer.parseInt(projectId.trim());
            return this;
        }

        public Builder dateFrom(LocalDate dateFrom) {
            this.dateFrom = dateFrom;
            return this;
        }

        public Builder dateTo(LocalDate dateTo) {
            this.dateTo = dateTo;
            return this;
        }

        public CsvRow build() {
            return new CsvRow(this);
        }
    }

    public static Builder getBuilder() {
        return new Builder();
    }
}
