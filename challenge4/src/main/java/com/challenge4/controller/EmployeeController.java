package com.challenge4.controller;

import com.challenge4.entity.Employee;
import com.challenge4.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping("employees/age")
    public List<Employee> getEmployees(@RequestParam int age) {
        return service.filterEmployeesBasedOnAge(age);
    }

    @GetMapping("employees/{department}")
    public List<Employee> getEmployeesWithSpecificDepartment(@PathVariable String department) {
        return service.filterEmployeesBasedOnDepartment(department);
    }

    @GetMapping("employees/fullName")
    public List<String> getEmployeesFullNameDetails() {
        return service.getEmployeesFullNameDetails();
    }

    @GetMapping("employees/Id")
    public List<Integer> getEmployeesIdDetails() {
        return service.getEmployeesIdDetails();
    }

    @GetMapping("employees/sort/salary")
    public List<Employee> sortEmployeesBasedOnSalary() {
        return service.sortEmployeesBasedOnSalary();
    }

    @GetMapping("employees/sort/age")
    public List<Employee> sortEmployeesBasedOnAge() {
        return service.sortEmployeesBasedOnAge();
    }

    @GetMapping("total/salary")
    public double getTotalSalary() {
        return service.totalSalary();
    }

    @GetMapping("employees/highestSalary")
    public Employee getEmployeeWithHighestSalary() {
        return service.getEmployeeWithHighestSalary();
    }

    @GetMapping("average/age")
    public double getAverageAgeOfEmployees() {
        return service.getAverageAgeOfEmployees();
    }

    @GetMapping("employees/department")
    public Map<String, List<Employee>> getEmployeesDepartmentWise() {
        return service.getEmployeesDepartmentWise();
    }
}
