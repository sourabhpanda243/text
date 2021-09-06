package com.example.payslip.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee_information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeInformation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "entry_number")
  private int entryNumber;

  @Column(name = "employee_Id")
  private String employeeId;

  @Column(name = "employee_name")
  private String employeeName;

  @Column(name = "designation")
  private String designation;

  @Column(name = "department")
  private String department;

  @Column(name = "date_of_joining")
  private Date dateOfJoining;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Column(name = "location")
  private String location;

  @Column(name = "panCard_No")
  private String panCardNo;

  @Column(name = "bank_name")
  private String bankName;

  @Column(name = "ifc_code")
  private String ifcCode;

  @Column(name = "account_Number")
  private String accountNumber;

  @Column(name = "Loss_of_pay_days")
  private String lossOfPayDays;

  @Column(name = "number_of_working_Days")
  private String numberOfWorkingDays;

  @Column(name = "annual_ctc")
  private String annualCtc;

  public int getEntryNumber() {
    return entryNumber;
  }

  public void setEntryNumber(int  entryNumber) {
    this.entryNumber = entryNumber;
  }

  public String getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
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

  public String getPanCardNo() {
    return panCardNo;
  }

  public void setPanCardNo(String panCardNo) {
    this.panCardNo = panCardNo;
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
    return "EmployeeInformation{"
        + "entryNumber="
        + entryNumber
        + ", employeeId='"
        + employeeId
        + '\''
        + ", employeeName='"
        + employeeName
        + '\''
        + ", designation='"
        + designation
        + '\''
        + ", department='"
        + department
        + '\''
        + ", dateOfJoining="
        + dateOfJoining
        + ", dateOfBirth="
        + dateOfBirth
        + ", location='"
        + location
        + '\''
        + ", panCardNo='"
        + panCardNo
        + '\''
        + ", bankName='"
        + bankName
        + '\''
        + ", ifcCode='"
        + ifcCode
        + '\''
        + ", accountNumber='"
        + accountNumber
        + '\''
        + ", lossOfPayDays='"
        + lossOfPayDays
        + '\''
        + ", numberOfWorkingDays='"
        + numberOfWorkingDays
        + '\''
        + ", annualCtc='"
        + annualCtc
        + '\''
        + '}';
  }
}
