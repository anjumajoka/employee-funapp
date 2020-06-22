package com.myfunapp.springboot.service;

import com.myfunapp.springboot.dao.EmployeeDAO;
import com.myfunapp.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> getEmployees() {

        List<Employee> employees = employeeDAO.getAllEmployee();

        return employees;
    }

    @Override
    public Employee getEmployeeOfId(int id) {
        return employeeDAO.getEmployeeOfId(id);
    }

    @Override
    public void deleteById(int id) {

        employeeDAO.deleteById(id);
    }
}
