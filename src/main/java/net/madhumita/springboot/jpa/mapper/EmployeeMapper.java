package net.madhumita.springboot.jpa.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.madhumita.springboot.jpa.dto.AddressDto;
import net.madhumita.springboot.jpa.dto.EmployeeDto;
import net.madhumita.springboot.jpa.model.Address;
import net.madhumita.springboot.jpa.model.Employee;

public class EmployeeMapper {
  public static Employee mapToEmployee(EmployeeDto employeeDto )
  {   
		/*
		 * List<Address>addressList = new ArrayList<>(addressDto);
		 * 
		 * Address add1 = new Address(); add1.setAddressId(addressDto.getAddressId());
		 * add1.setCity(addressDto.getCity());
		 * add1.setAddressType(addressDto.getAddressType());
		 * 
		 * Address add2 = new Address(); add2.setAddressId(addressDto.getAddressId()),
		 * add2.seCity(addressDto.getCity()),
		 * add2.setAddressType(addressDto.getAddressType();
		 * 
		 * addressList.add(add1); addressList.add(add2);
		 */
		      
		   Employee employee = new Employee();
		       employee.setId(employeeDto.getId());
		       employee.setFirstName(employeeDto.getFirstName());
		       employee.setLastName(employeeDto.getLastName());
		       employee.setEmailId(employeeDto.getEmailId());
		       employee.setAddress(employeeDto.getAddress());
		       
		
	return employee;
	  
  }
  public static EmployeeDto mapToemployeeDto(Employee employee)
  {  
	  
	  EmployeeDto employeeDto = new EmployeeDto(
			      employee.getId(),
			      employee.getFirstName(),
			      employee.getLastName(),
			      employee.getEmailId(),
			      employee.getAddress()
			      );
	  
	  return employeeDto;
  }
}
