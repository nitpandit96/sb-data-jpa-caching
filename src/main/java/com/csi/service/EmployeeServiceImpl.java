package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@Slf4j

public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDao;


    public Employee saveEmployeeData(Employee employee) {
        return employeeDao.saveEmployeeData(employee);
    }


    public List<Employee> getAllData() {


        log.info("Trying to get data from Database");
        return employeeDao.getAllData();
    }

    @Cacheable(value = "empId")
    public Optional<Employee> getEmployeeDataById(int empId) {

        log.info("Trying to get data by id from Database");
        return employeeDao.getDataById(empId);
    }

    public Employee updateEmployeeData(Employee employee) {
        return employeeDao.updateData(employee);
    }

    public void deleteDataById(int empId) {
        employeeDao.deleteData(empId);
    }
}
