package com.hatta.ems.util;

import com.hatta.ems.dto.EmployeeDTO;
import com.hatta.ems.entity.Employee;

public class EmployeeUtil {

    public static EmployeeDTO mapToEmployeeDTO(Employee emp){
        return new EmployeeDTO(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO empDto){
        return new Employee(
                empDto.getId(),
                empDto.getFirstName(),
                empDto.getLastName(),
                empDto.getEmail()
        );
    }
}
