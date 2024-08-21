package net.madhumita.springboot.jpa.dto;

import java.util.List;
import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.madhumita.springboot.jpa.model.Address;

public class EmployeeDto {
	
	private Long id;
	
	@NotBlank(message = "First name should'nt be blank!")
	private String firstName;
	
	@NotNull(message = "Last name should'nt be null")
	String lastName;
	
	@Email(message = "Invalid email address!")
	private String emailId;
	
	private List<Address> address;
	
	public EmployeeDto() {
		super();
		
	}
	public EmployeeDto(Long id, String firstName, String lastName, String emailId, List<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
	}

	
	  public Long getId() { return id; } 
	  
	  public void setId(Long id) { this.id = id;}
	 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, emailId, firstName, id, lastName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDto other = (EmployeeDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}
	@Override
	public String toString() {
		return "EmployeeDto [ firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", address=" + address + "]";
	}
	
}
