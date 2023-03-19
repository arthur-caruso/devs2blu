package tech.crud.employeemanager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.crud.employeemanager.exceptions.UserNotFoundException;
import tech.crud.employeemanager.models.Employee;
import tech.crud.employeemanager.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee create(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee findById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
}
