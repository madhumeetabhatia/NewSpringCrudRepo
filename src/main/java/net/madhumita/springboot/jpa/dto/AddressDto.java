package net.madhumita.springboot.jpa.dto;

import java.util.Objects;

public class AddressDto {

private Long addressId;

private String city;

private String addressType;

public AddressDto() {
		super();
		
	}
public AddressDto(Long addressId, String city, String addressType) {
	super();
	this.addressId = addressId;
	this.city = city;
	this.addressType = addressType;
	
}


public Long getAddressId() {
	return addressId;
}
public void setAddressId(Long addressId) {
	this.addressId = addressId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getAddressType() {
	return addressType;
}
public void setAddressType(String addressType) {
	this.addressType = addressType;
}


@Override
public int hashCode() {
	return Objects.hash(addressId, addressType, city);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AddressDto other = (AddressDto) obj;
	return Objects.equals(addressId, other.addressId) && Objects.equals(addressType, other.addressType)
			&& Objects.equals(city, other.city);
}
@Override
public String toString() {
	return "Address [addressId=" + addressId + ", city=" + city + ", addressType=" + addressType + "]";
}


}
