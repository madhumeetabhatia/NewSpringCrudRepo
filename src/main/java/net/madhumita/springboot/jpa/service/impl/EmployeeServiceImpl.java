package net.madhumita.springboot.jpa.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.madhumita.springboot.jpa.dto.EmployeeDto;
import net.madhumita.springboot.jpa.exception.ResourceNotFoundException;
import net.madhumita.springboot.jpa.mapper.EmployeeMapper;
import net.madhumita.springboot.jpa.model.Address;
import net.madhumita.springboot.jpa.model.Employee;
import net.madhumita.springboot.jpa.repository.AddressRepository;
import net.madhumita.springboot.jpa.repository.EmployeeRepository;
import net.madhumita.springboot.jpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

@Autowired
EmployeeRepository employeeRepository;
@Autowired
AddressRepository addressRepository;

   @Override
   public  EmployeeDto createEmployee(EmployeeDto employeeDto)
   {   
	List<Address> addressList = new ArrayList<Address>();
	
	Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	
	
	addressList =  employee.getAddress();
	
	System.out.println(addressList);

    for(Address address : addressList)
    {
    	addressRepository.save(address);
    }
   
	
	
	
	//Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
	
	Employee savedEmployee = employeeRepository.save(employee);
	
	
	return EmployeeMapper.mapToemployeeDto(savedEmployee);
	
   }

    @Override
    public EmployeeDto getEmployeeById(Long id)throws ResourceNotFoundException {
	Employee employee = employeeRepository
			.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id :"+ id));
	return EmployeeMapper.mapToemployeeDto(employee);
   }
 
   
    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) throws ResourceNotFoundException {
    	
	  List<Address> addressList = new ArrayList<Address>();
	  Employee employee = employeeRepository.findById(id)
			
		   .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id :"+ id));
	
	  employee.setId(employeeDto.getId());
	  employee.setFirstName(employeeDto.getFirstName());
	  employee.setLastName(employeeDto.getLastName());
	  employee.setEmailId(employeeDto.getEmailId());
	 
	  addressList = (employeeDto.getAddress());
	        
	  for(Address address : addressList)
	   {
	       addressRepository.save(address);
	    }
	       
	        	        
	        employee = employeeRepository.save(employee);
	        employee.setAddress(addressList);
	       
	        return EmployeeMapper.mapToemployeeDto(employee);
  }

    @Override
    public List<EmployeeDto> getAllEmployee() {
    	 
	 List<Employee>employees = employeeRepository.findAll();
	
	return employees.stream().map((employee)-> EmployeeMapper.mapToemployeeDto(employee)) 
			.collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long id) throws ResourceNotFoundException{
    	
	Employee employee = employeeRepository
			.findById(id)
			.orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with id :"+ id));
	employeeRepository.delete(employee);
   }
    
    
 
 
}  
