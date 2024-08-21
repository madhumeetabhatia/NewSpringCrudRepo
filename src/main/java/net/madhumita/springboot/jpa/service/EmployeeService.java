package net.madhumita.springboot.jpa.service;

import java.util.List;

import net.madhumita.springboot.jpa.dto.EmployeeDto;
import net.madhumita.springboot.jpa.exception.ResourceNotFoundException;
import net.madhumita.springboot.jpa.model.Employee;

public interface EmployeeService {
	
   EmployeeDto createEmployee(EmployeeDto employeeDto);
   
   EmployeeDto getEmployeeById(Long id);
   
   EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
   
   List<EmployeeDto> getAllEmployee();
   
   void deleteEmployee(Long id);


}
