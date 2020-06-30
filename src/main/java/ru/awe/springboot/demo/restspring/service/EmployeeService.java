package ru.awe.springboot.demo.restspring.service;

import ru.awe.springboot.demo.restspring.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployee(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);
}
