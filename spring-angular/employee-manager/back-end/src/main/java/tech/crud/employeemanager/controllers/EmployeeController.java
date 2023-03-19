package tech.crud.employeemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import tech.crud.employeemanager.models.Employee;
import tech.crud.employeemanager.services.EmployeeService;

@Data
@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.findAll();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
		Employee employee = employeeService.findById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.create(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee newEmployee = employeeService.save(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id) {
		employeeService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
