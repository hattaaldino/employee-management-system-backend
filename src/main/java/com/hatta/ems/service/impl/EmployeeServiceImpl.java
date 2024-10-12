package com.hatta.ems.service.impl;

import com.hatta.ems.dto.EmployeeDTO;
import com.hatta.ems.entity.Employee;
import com.hatta.ems.exception.ResourceNotFoundException;
import com.hatta.ems.repository.EmployeeRepository;
import com.hatta.ems.service.EmployeeService;
import com.hatta.ems.util.EmployeeUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeUtil.mapToEmployee(employeeDTO);

        Employee savedEmployee = employeeRepository.save(employee);

        // return employee dto with generated ID from database
        return EmployeeUtil.mapToEmployeeDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeByID(Long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id [" + empId + "] is not exist"));

        return EmployeeUtil.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> allEmployee = employeeRepository.findAll();

        return allEmployee
                .stream()
                .map(EmployeeUtil::mapToEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO empDTO) {
        Long empId = empDTO.getId();

        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id [" + empId + "] is not exist"));

        employee.setFirstName(empDTO.getFirstName());
        employee.setLastName(empDTO.getLastName());
        employee.setEmail(empDTO.getEmail());

        return EmployeeUtil.mapToEmployeeDTO(employee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.findById(empId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee with id [" + empId + "] is not exist"));

        employeeRepository.deleteById(empId);
    }

    @Override
    public void deleteAllEmployee() {
        employeeRepository.deleteAll();
    }
}
