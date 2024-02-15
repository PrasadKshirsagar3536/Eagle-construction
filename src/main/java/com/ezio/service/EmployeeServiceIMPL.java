package com.ezio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.ezio.entity.Employee;
import com.ezio.repository.EmployeeRepository;

@Service
public class EmployeeServiceIMPL implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String authenticateUser(String email, String password) {
		Optional<Employee> employeeOptional = employeeRepository.findByEmailAndPassword(email, password);

		if (employeeOptional.isPresent()) {
			Employee employee = employeeOptional.get();
			if ("admin".equals(employee.getRole())) {
				return "admin/admin-dashboard";
			} else if ("employee".equals(employee.getRole())) {
				return "employee/employee-dashboard";
			}
		}

		return "error";
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}      
	
	@Override
	public Employee getEmployeeById(Long empId) {
		return employeeRepository.findById(empId).get();
	}

	@Override
	public Employee updatEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}
}
