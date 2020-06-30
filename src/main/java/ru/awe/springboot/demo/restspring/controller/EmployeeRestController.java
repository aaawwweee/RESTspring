package ru.awe.springboot.demo.restspring.controller;

import org.springframework.web.bind.annotation.*;
import ru.awe.springboot.demo.restspring.entity.Employee;
import ru.awe.springboot.demo.restspring.exceptions.EmployeeNotFoundException;
import ru.awe.springboot.demo.restspring.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployyees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.getEmployee(employeeId);
        if (theEmployee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        employeeService.saveEmployee(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeid}")
    public String deleteEmployee(@PathVariable int employeeid) {
        Employee tempEmployee = employeeService.getEmployee(employeeid);
        if (tempEmployee == null) {
            throw new EmployeeNotFoundException("Employee id not found - " + employeeid);
        }

        employeeService.deleteEmployee(employeeid);

        return "Deleted employee id - " + employeeid;
    }

}
