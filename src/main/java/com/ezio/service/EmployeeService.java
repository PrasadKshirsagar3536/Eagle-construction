package com.ezio.service;

import java.util.List;

import com.ezio.entity.Employee;

public interface EmployeeService {

    String authenticateUser(String email, String password);
    Employee addEmployee(Employee employee);
    List<Employee> getAll();
	Employee getEmployeeById(Long empId);
	Employee updatEmployee(Employee employee);
	void deleteEmployee(Long empId);

}
