package net.madhumita.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.madhumita.springboot.jpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
