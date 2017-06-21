package com.checkmarx.sonar.sensor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by: Zoharby.
 * Date: 14/06/2017.
 */
public class QueryData {

    @JsonProperty("name")
    private String name;
    @JsonProperty("severity")
    private int severity;
    @JsonProperty("numberOfOccurrences")
    private int numberOfOccurrences;

    public QueryData(String name, int severity, int numberOfOccurrences) {
        this.name = name;
        this.severity = severity;
        this.numberOfOccurrences = numberOfOccurrences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getNumberOfOccurrences() {
        return numberOfOccurrences;
    }

    public void setNumberOfOccurrences(int numberOfOccurrences) {
        this.numberOfOccurrences = numberOfOccurrences;
    }
}
