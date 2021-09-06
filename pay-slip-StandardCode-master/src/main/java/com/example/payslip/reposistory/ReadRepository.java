package com.example.payslip.reposistory;

import com.example.payslip.entity.EmployeeInformation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReadRepository extends CrudRepository<EmployeeInformation ,String> {

    Optional<EmployeeInformation> findByEmployeeId(final String employeeId);




}
