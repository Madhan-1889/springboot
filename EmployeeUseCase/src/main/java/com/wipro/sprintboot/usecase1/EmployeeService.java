package com.wipro.sprintboot.usecase1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	// Valid roles
	private static final List<String> ALLOWED_ROLES = List.of("Developer", "Manager", "Tester");

	// Add Employee
	public Employee addEmployee(String name, String role) {
		if (!ALLOWED_ROLES.contains(role)) {
			throw new InvalidRoleException(
					"Invalid role: " + role + ". Allowed roles are: Developer, Manager, Tester.");
		}
		Employee employee = new Employee(name, role);
		return repository.save(employee);
	}

	// Get All Employees
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}
}
