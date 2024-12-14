package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepo employeeRepo;


    public Employee saveEmployeeData(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAllData() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getDataById(int empId) {
        return employeeRepo.findById(empId);
    }

    public Employee updateData(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteData(int empId) {
        employeeRepo.deleteById(empId);
    }
}
