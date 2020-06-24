package com.myfunapp.springboot.service;

import com.myfunapp.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee getEmployeeOfId(int id);

    void deleteById(int id);

    Employee saveEmployee(Employee employee);
}
