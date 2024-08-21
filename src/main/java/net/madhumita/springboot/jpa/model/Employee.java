package net.madhumita.springboot.jpa.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	private Long  id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	
	
	@OneToMany(cascade  = CascadeType.ALL)
	@JoinColumn(name = "Fk_empId",referencedColumnName = "Id")
    private List<Address> address;
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", address=" + address + "]";
	}

	public Employee() {
		super();
		
	}

	public Employee(Long id, String firstName, String lastName, String emailId, List<Address> address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Address> getAddress() {
		return address;
	}

	

	

	
	
}
