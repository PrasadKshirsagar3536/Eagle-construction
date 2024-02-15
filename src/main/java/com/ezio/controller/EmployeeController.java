package com.ezio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.entity.Employee;
import com.ezio.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// Backed API's

	@PostMapping("/add")
	@ResponseBody
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/get")
	@ResponseBody
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("/showOne/{empId}")
	@ResponseBody
	public Employee showOne(@PathVariable Long empId) {
		return employeeService.getEmployeeById(empId);
	}

	@PutMapping("/update")
	@ResponseBody
	public Employee update(@RequestBody Employee employee) {
		return employeeService.updatEmployee(employee);
	}

	@DeleteMapping("/remove/{empId}")
	@ResponseBody
	public void delete(@PathVariable Long empId) {
		employeeService.deleteEmployee(empId);
	}

	// Fronted API's

	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String email, String password, Model model) {

		String dashboard = employeeService.authenticateUser(email, password);

		if ("error".equals(dashboard)) {
			model.addAttribute("error", "Invalid credentials");
			return "login";
		} else {
			return dashboard;
		}
	}

	@GetMapping("/admin-dashboard")
	public String adminDashboard() {

		return "admin/admin-dashboard";
	}

	@GetMapping("/admin-employee")
	public String adminEmployeePage() {

		return "admin/admin-add-employee";
	}

	@GetMapping("/employee-dashboard")
	public String employeeDashboard() {
		return "employee-dashboard";
	}

	@PostMapping("/addEmployee")
	public Employee add(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}

	@GetMapping("/getEmployees")
	public String getall(Model model) {
		model.addAttribute("eagleconstruction", employeeService.getAll());
		return "basic-table";
	}

}
