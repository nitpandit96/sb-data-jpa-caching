package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/saveemployeedata")
    public Employee saveEmployeeData(@RequestBody Employee employee)
    {
        log.info("Trying to save into db");
        return employeeService.saveEmployeeData(employee);
    }

    @GetMapping("/getemployeedata")
    public List<Employee> getEmployeeData()
    {
        return employeeService.getAllData();

    }

    @GetMapping("/getemployeedatabyid/{empId}")
    public Optional<Employee> getEmployeeDataById(@PathVariable int empId)
    {
        return employeeService.getEmployeeDataById(empId);

    }

    @PutMapping("/updateemployeedata/{empId}")
    public Employee updateEmployeeData(@PathVariable int empId, @RequestBody Employee employee)
    {


       return employeeService.updateEmployeeData(employee);
    }

    @DeleteMapping("/deleteemployeedata/{empId}")
    public String deleteEmployeeDataById(@PathVariable int empId)
    {
        employeeService.deleteDataById(empId);
        return "Data deleted Successfully";
    }

}
