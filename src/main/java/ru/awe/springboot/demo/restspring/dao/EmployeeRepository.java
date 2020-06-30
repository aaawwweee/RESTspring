package ru.awe.springboot.demo.restspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.awe.springboot.demo.restspring.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
