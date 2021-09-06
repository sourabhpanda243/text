package com.example.payslip.reposistory;

import com.example.payslip.entity.EmployeeInformation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WriteRepository extends CrudRepository<EmployeeInformation,String> {
//    @Query (value= "SELECT * FROM payslip.employee_information_details ORDER BY  entry_number DESC LIMIT  1",nativeQuery =true)
}
