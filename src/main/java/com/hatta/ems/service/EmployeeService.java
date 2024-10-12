package com.hatta.ems.service;

import com.hatta.ems.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    
    EmployeeDTO getEmployeeByID(Long empId);

    List<EmployeeDTO> getAllEmployee();

    EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(Long empId);

    void deleteAllEmployee();
}
