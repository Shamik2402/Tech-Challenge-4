package com.challenge4.service;

import com.challenge4.entity.Employee;
import com.challenge4.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    @Override
    public List<Employee> filterEmployeesBasedOnAge(int age) {
        return repository.findAll().stream().filter(employee -> employee.getAge()>age).toList();
    }

    @Override
    public List<Employee> filterEmployeesBasedOnDepartment(String department) {
        return repository.findAll().stream().filter(employee -> Objects.equals(employee.getDepartment(), department)).toList();
    }

    @Override
    public List<String> getEmployeesFullNameDetails() {
        return repository.findAll().stream().map(employee -> employee.getFirstName() + " " + employee.getLastName()).toList();
    }

    @Override
    public List<Integer> getEmployeesIdDetails() {
        return repository.findAll().stream().map(Employee::getId).toList();
    }

    @Override
    public List<Employee> sortEmployeesBasedOnSalary() {
        return repository.findAll().stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
    }

    @Override
    public List<Employee> sortEmployeesBasedOnAge() {
        return repository.findAll().stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).toList();
    }

    @Override
    public double totalSalary() {
        return repository.findAll().stream().mapToDouble(Employee::getSalary).reduce(Double::sum).getAsDouble();
    }

    @Override
    public Employee getEmployeeWithHighestSalary() {
        return repository.findAll().stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
    }

    @Override
    public double getAverageAgeOfEmployees() {
        return repository.findAll().stream().mapToInt(Employee::getAge).average().getAsDouble();
    }

    @Override
    public Map<String, List<Employee>> getEmployeesDepartmentWise() {
        return repository.findAll().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
