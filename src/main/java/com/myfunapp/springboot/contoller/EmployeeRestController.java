package com.myfunapp.springboot.contoller;

import com.myfunapp.springboot.entity.Employee;
import com.myfunapp.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<Employee> getEmployees(){

        List<Employee> employees = employeeService.getEmployees();

        return employees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){

        Employee employee = employeeService.getEmployeeOfId(id);

        if (employee == null){
            throw new RuntimeException("employee is not found of " +id );
        }

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteById(@PathVariable int id){
        Employee employee = employeeService.getEmployeeOfId(id);

        if (employee == null) {
            throw new RuntimeException("employee is not found of " + id);
        }

        employeeService.deleteById(id);

        }
}
