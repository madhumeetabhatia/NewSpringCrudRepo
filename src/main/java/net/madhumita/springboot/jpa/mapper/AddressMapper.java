package net.madhumita.springboot.jpa.mapper;

import net.madhumita.springboot.jpa.dto.AddressDto;

import net.madhumita.springboot.jpa.model.Address;


public class AddressMapper {
	public static Address mapToAddresse(AddressDto addressDto) {
		
	     Address address = new Address();	
		 address.setAddressId(addressDto.getAddressId());
		 address.setCity(addressDto.getCity());
		 address.setAddressType(addressDto.getAddressType());
		 
	 return address;	
	}
	public static AddressDto mapToAddresseDto(Address address) 
	{
		AddressDto addressDto = new AddressDto();
		
		addressDto.setAddressId(address.getAddressId());
		addressDto.setCity(address.getCity());
		addressDto.setAddressType(address.getAddressType());
		
		return addressDto;
	
	}
}
	  
