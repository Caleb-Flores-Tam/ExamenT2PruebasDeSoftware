package com.coudevi.model;

public class EmployeeData {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String employeeId;

    public EmployeeData(String firstName, String middleName, String lastName, String employeeId) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }
    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }
    public String getEmployeeId() { return employeeId; }
}
