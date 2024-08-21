package net.madhumita.springboot.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import net.madhumita.springboot.jpa.dto.EmployeeDto;
import net.madhumita.springboot.jpa.exception.ResourceNotFoundException;
import net.madhumita.springboot.jpa.model.Employee;
import net.madhumita.springboot.jpa.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
	private EmployeeService employeeService;
	
	// get all employees
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployee();
		return ResponseEntity.ok(employees);
	}		
	
	// create employee rest api
	@PostMapping("/createEmployee")
	public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody  EmployeeDto employeeDto) {
		
		return  new ResponseEntity<>(employeeService.createEmployee(employeeDto),HttpStatus.CREATED);
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
				    
		return ResponseEntity.ok(employeeDto);
	}
	
	// update employee rest api
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,@Valid @RequestBody EmployeeDto employeeDto){
		
		EmployeeDto employeeDtoo = employeeService.updateEmployee(id, employeeDto);
		return ResponseEntity.ok(employeeDtoo);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
				
		employeeService.deleteEmployee(id);
	return ResponseEntity.ok("Employee is deleted successfully !");
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ResourceNotFoundException.class)
	public Map<String, String> handlerResourceNtFound(ResourceNotFoundException ex)
	{
		Map<String ,String> errorMap = new HashMap<>();
		
		errorMap.put("errorMessage",ex.getMessage());
	return errorMap;
	}
	
	
}
