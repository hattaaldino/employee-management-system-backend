package com.hatta.ems.controller;

import com.hatta.ems.dto.EmployeeDTO;
import com.hatta.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/insert")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<EmployeeDTO>(createdEmployee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<EmployeeDTO> getEmployeeByID(@RequestParam(value = "id") Long empId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeByID(empId);

        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        List<EmployeeDTO> allEmployee = employeeService.getAllEmployee();

        return ResponseEntity.ok(allEmployee);
    }

    @PostMapping("/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeDTO);

        return ResponseEntity.ok(updatedEmployee);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteEmployee(@RequestParam(value = "id") Long empId){
        employeeService.deleteEmployee(empId);

        return new ResponseEntity<String>(
                "Employee [" + empId + "] is deleted",
                HttpStatus.OK
        );
    }

    @PostMapping("/delete/all")
    public ResponseEntity<String> deleteAllEmployee(){
        employeeService.deleteAllEmployee();

        return new ResponseEntity<String>(
                "All Employee are deleted",
                HttpStatus.OK
        );
    }
}
