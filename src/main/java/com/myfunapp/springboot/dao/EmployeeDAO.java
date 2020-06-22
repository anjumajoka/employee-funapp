package com.myfunapp.springboot.dao;

import com.myfunapp.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployee();

    Employee getEmployeeOfId(int id);

    void deleteById(int id);

    Employee saveEmployee(Employee employee);
}
