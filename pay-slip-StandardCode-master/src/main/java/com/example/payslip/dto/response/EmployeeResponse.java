package com.example.payslip.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeResponse {
  private int  entryNumber;
  private String employeeName;
  private String employeeId;
  private String designation;
  private String department;
  private Integer employeeResponseCode;
  //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date dateOfJoining;
  //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private Date dateOfBirth;
  private String location;
  private String pan;
  private String bankName;
  private String ifcCode;
  private String accountNumber;
  private String lossOfPayDays;
  private String  numberOfWorkingDays;
  private String  annualCtc;

  public int  getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(int entryNumber) {
    this.entryNumber = entryNumber;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public Integer getEmployeeResponseCode() {
    return employeeResponseCode;
  }

  public void setEmployeeResponseCode(Integer employeeResponseCode) {
    this.employeeResponseCode = employeeResponseCode;
  }

  public Date getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining(Date dateOfJoining) {
    this.dateOfJoining = dateOfJoining;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPan() {
    return pan;
  }

  public void setPan(String pan) {
    this.pan = pan;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getIfcCode() {
    return ifcCode;
  }

  public void setIfcCode(String ifcCode) {
    this.ifcCode = ifcCode;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getLossOfPayDays() {
    return lossOfPayDays;
  }

  public void setLossOfPayDays(String lossOfPayDays) {
    this.lossOfPayDays = lossOfPayDays;
  }

  public String getNumberOfWorkingDays() {
    return numberOfWorkingDays;
  }

  public void setNumberOfWorkingDays(String numberOfWorkingDays) {
    this.numberOfWorkingDays = numberOfWorkingDays;
  }

  public String getAnnualCtc() {
    return annualCtc;
  }

  public void setAnnualCtc(String annualCtc) {
    this.annualCtc = annualCtc;
  }

  @Override
  public String toString() {
    return "EmployeeResponse{" +
            "entryNumber=" + entryNumber +
            ", employeeName='" + employeeName + '\'' +
            ", employeeId='" + employeeId + '\'' +
            ", designation='" + designation + '\'' +
            ", department='" + department + '\'' +
            ", employeeResponseCode=" + employeeResponseCode +
            ", dateOfJoining=" + dateOfJoining +
            ", dateOfBirth=" + dateOfBirth +
            ", location='" + location + '\'' +
            ", pan='" + pan + '\'' +
            ", bankName='" + bankName + '\'' +
            ", ifcCode='" + ifcCode + '\'' +
            ", accountNumber='" + accountNumber + '\'' +
            ", lossOfPayDays='" + lossOfPayDays + '\'' +
            ", numberOfWorkingDays='" + numberOfWorkingDays + '\'' +
            ", annualCtc='" + annualCtc + '\'' +
            '}';
  }
}
