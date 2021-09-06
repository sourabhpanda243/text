package com.example.payslip.service;

import com.example.payslip.enums.ResponseStatusCode;
import com.example.payslip.dto.request.EmployeeRequest;
import com.example.payslip.dto.response.EmployeeResponse;

import com.example.payslip.dto.response.ResponseObject;
import com.example.payslip.entity.EmployeeInformation;
import com.example.payslip.reposistory.ReadRepository;
import com.example.payslip.reposistory.WriteRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements PaySlipService {

  private static final Logger LOG = LoggerFactory.getLogger(ServiceImpl.class);

  @Autowired private WriteRepository writeRepository;
  @Autowired private ReadRepository readRepository;

  /**
   * Each and every employee PAYSLIP'S data store in data base.
   *
   * @param employeeRequest
   * @return If particular person data store in DB send SUCCESS code or Return FAIL code.
   */
  // store in db or save in db all employee information


  //---------------post method for saving all the datas----------//

  @Override
  public ResponseObject<EmployeeResponse> employeeDetails(final EmployeeRequest employeeRequest) {
    LOG.trace("-->EXIT--> employeeDetails :: {}", employeeRequest);
    EmployeeResponse employeeResponse = new EmployeeResponse();
    Optional<EmployeeInformation> optionalEmployeeInformation = Optional.empty();
    try {
        optionalEmployeeInformation = readRepository.findByEmployeeId(employeeRequest.getEmployeeId());
    } catch (Exception ex) {
      LOG.error(
          "--findByOrderId() -->> Encountered exception while fetching the log entity from DB ::",
          ex);
    }
    if (!optionalEmployeeInformation.isPresent()) {
      final EmployeeInformation employeeInformation = new EmployeeInformation();
      employeeInformation.setEmployeeId(employeeRequest.getEmployeeId());
      employeeInformation.setEmployeeName(employeeRequest.getEmployeeName());
      employeeInformation.setDesignation(employeeRequest.getDesignation());
      employeeInformation.setDepartment(employeeRequest.getDepartment());
      employeeInformation.setDateOfJoining(employeeRequest.getDateOfJoining());
      employeeInformation.setDateOfBirth(employeeRequest.getDateOfBirth());
      employeeInformation.setLocation(employeeRequest.getLocation());
      employeeInformation.setPanCardNo(employeeRequest.getPan());
      employeeInformation.setBankName(employeeRequest.getBankName());
      employeeInformation.setIfcCode(employeeRequest.getIfcCode());
      employeeInformation.setAccountNumber(employeeRequest.getAccountNumber());
      employeeInformation.setLossOfPayDays(employeeRequest.getLossOfPayDays());
      employeeInformation.setNumberOfWorkingDays(employeeRequest.getNumberOfWorkingDays());
      employeeInformation.setAnnualCtc(employeeRequest.getAnnualCtc());
      writeRepository.save(employeeInformation);

      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.SUCCESS.getCode());
      employeeResponse.setEmployeeId(employeeRequest.getEmployeeId());
      employeeResponse.setEmployeeName(employeeRequest.getEmployeeName());
      employeeResponse.setDesignation(employeeRequest.getDesignation());
      employeeResponse.setDepartment(employeeRequest.getDepartment());
      employeeResponse.setDateOfJoining(employeeRequest.getDateOfJoining());
      employeeResponse.setDateOfBirth(employeeRequest.getDateOfBirth());
      employeeResponse.setLocation(employeeRequest.getLocation());
      employeeResponse.setPan(employeeRequest.getPan());
      employeeResponse.setBankName(employeeRequest.getBankName());
      employeeResponse.setIfcCode(employeeRequest.getIfcCode());
      employeeRequest.setAccountNumber(employeeRequest.getAccountNumber());
      employeeResponse.setLossOfPayDays(employeeRequest.getNumberOfWorkingDays());
      employeeResponse.setNumberOfWorkingDays(employeeRequest.getNumberOfWorkingDays());
      employeeResponse.setAnnualCtc(employeeRequest.getAnnualCtc());
    } else {
      LOG.info("This employee ID AllReady Exist Our database..!");
      employeeResponse.setEmployeeId(employeeRequest.getEmployeeId());
      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.USER_ID_ALREADY_EXIST.getCode());
    }
    LOG.trace("-->EXIT--> employeeDetails :: {}", employeeRequest);
    return ResponseObject.success(employeeResponse);
  }

  /**
   * Get the particular employee payslip's data using employee ID.
   *
   * @param employeeId
   * @return If found employee data return employee data or return FAIL code.
   */

  //------------------------get method for getting all the datas-----------------//

  @Override
  public ResponseObject<EmployeeResponse> getPaySlip(final String employeeId) {
    LOG.trace("-->>ENTRY>> getPaySlip() :: {}", employeeId);
    final EmployeeResponse employeeResponse = new EmployeeResponse();
    Optional<EmployeeInformation> optionalEmployeeInformation = Optional.empty();
    try {
      optionalEmployeeInformation = readRepository.findByEmployeeId(employeeId);
    } catch (Exception ex) {
      LOG.error(
          "--findByOrderId() -->> Encountered exception while fetching the log entity from DB ::",
          ex);
    }
    if (optionalEmployeeInformation.isPresent()) {
      EmployeeInformation employeeInformation = optionalEmployeeInformation.get();
      employeeResponse.setEntryNumber(employeeInformation.getEntryNumber());
      employeeResponse.setEmployeeId(employeeInformation.getEmployeeId());
      employeeResponse.setDesignation(employeeInformation.getDesignation());
      employeeResponse.setDepartment(employeeInformation.getDepartment());
      employeeResponse.setDateOfJoining(employeeInformation.getDateOfJoining());
      employeeResponse.setDateOfBirth(employeeInformation.getDateOfBirth());
      employeeResponse.setLocation(employeeInformation.getLocation());
      employeeResponse.setPan(employeeInformation.getPanCardNo());
      employeeResponse.setBankName(employeeInformation.getBankName());
      employeeResponse.setIfcCode(employeeInformation.getIfcCode());
      employeeResponse.setAccountNumber(employeeInformation.getAccountNumber());
      employeeResponse.setLossOfPayDays(employeeInformation.getNumberOfWorkingDays());
      employeeResponse.setNumberOfWorkingDays(employeeInformation.getNumberOfWorkingDays());
      employeeResponse.setAnnualCtc(employeeInformation.getAnnualCtc());
      employeeResponse.setEmployeeName(employeeInformation.getEmployeeName());

      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.SUCCESS.getCode());
    } else {
      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.USER_ID_NOT_EXIST.getCode());
    }
    LOG.trace("<--EXIT<-- getPaySlip() :: {}", employeeId);
    return ResponseObject.success(employeeResponse);
  }

  /**
   * particular employee records delete
   *
   * @param employeeId
   * @return if delete data Success return Success Code or return FAIL code
   */

  // ------------------------delete for delete all the datas------------------------//

  @Override
  public ResponseObject<EmployeeResponse> deleteEmployeeInformation(final String employeeId) {
    LOG.trace("-->>ENTRY>> deleteEmployeeInformation() :: {}", employeeId);
    final EmployeeResponse employeeResponse = new EmployeeResponse();
    Optional<EmployeeInformation> optionalEmployeeInformation = Optional.empty();

    try {
      optionalEmployeeInformation = readRepository.findByEmployeeId(employeeId);
    } catch (Exception ex) {
      LOG.error(
          "-- findByEmployeeId() --> Encountered exception while fetching Events entity from DB. Exception :: ",
          ex);
    }
    if (optionalEmployeeInformation.isPresent()) {
      EmployeeInformation employeeInformation = optionalEmployeeInformation.get();
      readRepository.delete(employeeInformation);

      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.SUCCESS.getCode());
    } else {
      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.FAIL.getCode());
    }
    LOG.trace("<--EXIT<-- deleteEmployeeInformation() :: {}", employeeId);
    return ResponseObject.success(employeeResponse);
  }

  /**
   * particular employee data do modification based on employeeID.
   *
   * @param employeeRequest
   * @return if particular person data update return code Success and updated data or FAIL code.
   */

  //---------------update the datas--------------------------//


  @Override
  public ResponseObject<EmployeeResponse> updateEmployeeInformationByEmployeeId(
      final EmployeeRequest employeeRequest) {
    LOG.trace("-->>ENTRY>> updateEmployeeInformationByEmployeeId() :: {}", employeeRequest);
    EmployeeResponse employeeResponse = new EmployeeResponse();
    Optional<EmployeeInformation> optionalEmployeeInformation = Optional.empty();

    try {
      optionalEmployeeInformation =
          readRepository.findByEmployeeId(employeeRequest.getEmployeeId());
    } catch (Exception ex) {
      LOG.error(
          "-- findByEmployeeId() --> Encountered exception while fetching Events entity from DB. Exception :: ",
          ex);
    }
    if (optionalEmployeeInformation.isPresent()) {
      EmployeeInformation employeeInformation = optionalEmployeeInformation.get();
      employeeInformation.setEmployeeId(employeeRequest.getEmployeeId());
      employeeInformation.setEmployeeName(employeeRequest.getEmployeeName());
      employeeInformation.setDesignation(employeeRequest.getDesignation());
      employeeInformation.setDepartment(employeeRequest.getDepartment());
      employeeInformation.setDateOfJoining(employeeRequest.getDateOfJoining());
      employeeInformation.setDateOfBirth(employeeRequest.getDateOfBirth());
      employeeInformation.setLocation(employeeRequest.getLocation());
      employeeInformation.setPanCardNo(employeeRequest.getPan());
      employeeInformation.setBankName(employeeRequest.getBankName());
      employeeInformation.setIfcCode(employeeRequest.getIfcCode());
      employeeInformation.setAccountNumber(employeeRequest.getAccountNumber());
      employeeInformation.setLossOfPayDays(employeeRequest.getLossOfPayDays());
      employeeInformation.setNumberOfWorkingDays(employeeRequest.getNumberOfWorkingDays());
      employeeInformation.setAnnualCtc(employeeRequest.getAnnualCtc());
      readRepository.save(employeeInformation);
      employeeResponse.setEmployeeId(employeeInformation.getEmployeeId());
      employeeResponse.setEntryNumber(employeeInformation.getEntryNumber());
      employeeResponse.setEmployeeName(employeeInformation.getEmployeeName());
      employeeResponse.setDesignation(employeeInformation.getDesignation());
      employeeResponse.setDepartment(employeeInformation.getDepartment());
      employeeResponse.setDateOfJoining(employeeInformation.getDateOfJoining());
      employeeResponse.setDateOfBirth(employeeInformation.getDateOfBirth());
      employeeResponse.setLocation(employeeInformation.getLocation());
      employeeResponse.setPan(employeeInformation.getPanCardNo());
      employeeResponse.setBankName(employeeInformation.getBankName());
      employeeResponse.setIfcCode(employeeInformation.getIfcCode());
      employeeResponse.setAccountNumber(employeeInformation.getAccountNumber());
      employeeResponse.setLossOfPayDays(employeeInformation.getNumberOfWorkingDays());
      employeeResponse.setNumberOfWorkingDays(employeeInformation.getNumberOfWorkingDays());
      employeeResponse.setAnnualCtc(employeeInformation.getAnnualCtc());
      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.SUCCESS.getCode());
    } else {
      employeeResponse.setEmployeeResponseCode(ResponseStatusCode.FAIL.getCode());
    }
    LOG.trace("<--EXIT<-- updateEmployeeInformationByEmployeeId() :: {}", employeeRequest);
    return ResponseObject.success(employeeResponse);
  }
}
