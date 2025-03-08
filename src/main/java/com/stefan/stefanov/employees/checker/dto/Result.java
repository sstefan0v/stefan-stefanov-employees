package com.stefan.stefanov.employees.checker.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Result {
    @JsonProperty
    private int emp1Id;
    @JsonProperty
    private int emp2Id;
    @JsonProperty
    private int projectId;
    @JsonProperty
    private long lengthDays;

    public Result(int emp1Id, int emp2Id, int projectId, long lengthDays) {
        this.emp1Id = Math.min(emp1Id, emp2Id);
        this.emp2Id = Math.max(emp1Id, emp2Id);
        this.projectId = projectId;
        this.lengthDays = lengthDays;
    }
}
