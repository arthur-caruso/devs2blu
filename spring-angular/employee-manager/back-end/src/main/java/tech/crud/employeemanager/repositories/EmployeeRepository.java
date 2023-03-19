package tech.crud.employeemanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.crud.employeemanager.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Optional<Employee> findById(Long id);

	public void deleteById(Long id);
}
