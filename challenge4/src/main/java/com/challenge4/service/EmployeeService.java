package com.challenge4.service;

import com.challenge4.entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    List<Employee> filterEmployeesBasedOnAge(int age);
    List<Employee> filterEmployeesBasedOnDepartment(String department);

    List<String> getEmployeesFullNameDetails();

    List<Integer> getEmployeesIdDetails();

    List<Employee> sortEmployeesBasedOnSalary();

    List<Employee> sortEmployeesBasedOnAge();

    double totalSalary();

    Employee getEmployeeWithHighestSalary();

    double getAverageAgeOfEmployees();

    Map<String, List<Employee>> getEmployeesDepartmentWise();

}
