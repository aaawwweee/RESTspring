package ru.awe.springboot.demo.restspring.service;

import org.springframework.stereotype.Service;
import ru.awe.springboot.demo.restspring.dao.EmployeeRepository;
import ru.awe.springboot.demo.restspring.entity.Employee;
import ru.awe.springboot.demo.restspring.exceptions.EmployeeNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if (result.isPresent()) {
            employee = result.get();
        } else {
            throw new EmployeeNotFoundException("Didn't find employee id - " + id);
        }
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
