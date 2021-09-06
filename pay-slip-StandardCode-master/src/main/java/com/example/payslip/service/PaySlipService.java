package com.example.payslip.service;

import com.example.payslip.dto.request.EmployeeRequest;
import com.example.payslip.dto.response.EmployeeResponse;
import com.example.payslip.dto.response.ResponseObject;


public interface PaySlipService {

      ResponseObject<EmployeeResponse> employeeDetails(final EmployeeRequest employeeRequest);

       ResponseObject<EmployeeResponse> getPaySlip(final String employeeId);

      ResponseObject<EmployeeResponse> deleteEmployeeInformation(String employeeId);

      ResponseObject<EmployeeResponse> updateEmployeeInformationByEmployeeId(final EmployeeRequest employeeRequest);

}
