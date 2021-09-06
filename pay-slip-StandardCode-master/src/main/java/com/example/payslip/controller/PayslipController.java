package com.example.payslip.controller;

import com.example.payslip.dto.request.EmployeeRequest;
import com.example.payslip.dto.response.EmployeeResponse;
import com.example.payslip.dto.response.ResponseObject;
import com.example.payslip.service.PaySlipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CrossOrigin(origins = "*", maxAge = 36000)
@RestController
@RequestMapping("/v1")
public class PayslipController {

  private static final Logger LOG = LoggerFactory.getLogger(PayslipController.class);
  @Autowired PaySlipService paySlipService;

  /**
   * @param employeeRequest
   * @return
   */
  @PostMapping(path = "/payslip", produces = "Application/json")
  public ResponseEntity<ResponseObject<EmployeeResponse>> employeeDetails(@Valid @RequestBody final EmployeeRequest employeeRequest)
  {
      LOG.trace("-->ENTRY--> employeeDetails() :: {}", employeeRequest);
      ResponseObject<EmployeeResponse> employeeResponseResponseObject = paySlipService.employeeDetails(employeeRequest);
    LOG.trace("-->EXIT--> employeeDetails() :: {}", employeeRequest);
    return ResponseEntity.ok(employeeResponseResponseObject);
  }

  /**
   * @param employeeId
   * @return
   */
  @GetMapping(path = "/getPayslip/{employeeId}", produces = "Application/json")
  public ResponseEntity<ResponseObject<EmployeeResponse>> getEmployeeDetail(@PathVariable("employeeId") final String employeeId)
  {
    LOG.trace("-->ENTRY--> getEmployeeDetail() :: {}", employeeId);
    ResponseObject<EmployeeResponse> employeeResponseResponseObject = paySlipService.getPaySlip(employeeId);
    LOG.trace("-->EXIT--> getEmployeeDetail() :: {}", employeeId);
    return ResponseEntity.ok(employeeResponseResponseObject);
  }

  /**
   * @param employeeId
   * @return
   */
  @DeleteMapping(path = "/deleteEmployeeInformation/{employeeId}", produces = "Application/json")
  public ResponseEntity<ResponseObject<EmployeeResponse>> deleteEmployeeInformation(@PathVariable("employeeId") final String employeeId)
  {
    LOG.trace("-->ENTRY--> deleteEmployeeInformation() :: {}", employeeId);
    ResponseObject<EmployeeResponse> employeeResponseResponseObject = paySlipService.deleteEmployeeInformation(employeeId);
    LOG.trace("-->EXIT--> deleteEmployeeInformation() :: {}", employeeId);
    return ResponseEntity.ok(employeeResponseResponseObject);
  }

  /**
   * @param employeeRequest
   * @return
   */
  @PutMapping(path = "/updateEmployeePaySlip", produces = "Application/json")
  public ResponseEntity<ResponseObject<EmployeeResponse>> updatePaySlip(@Valid @RequestBody final EmployeeRequest employeeRequest)
  {
    LOG.trace("-->ENTRY--> updatePaySlip() :: {}", employeeRequest);
    ResponseObject<EmployeeResponse> employeeResponseResponseObject = paySlipService.updateEmployeeInformationByEmployeeId(employeeRequest);
    LOG.trace("-->EXIT--> updatePaySlip() :: {}", employeeRequest);
    return ResponseEntity.ok(employeeResponseResponseObject);
  }
}
