package com.wipro.sprintboot.usecase1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// Add Employee
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestParam String name, @RequestParam String role) {
		try {
			Employee employee = service.addEmployee(name, role);
			return new ResponseEntity<>(employee, HttpStatus.CREATED);
		} catch (InvalidRoleException ex) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST); // Return 400 if role is invalid
		}
	}

	// Get All Employees
	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
}
