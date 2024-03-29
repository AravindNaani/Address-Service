package com.tel.AddressService.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tel.AddressService.dao.AddressRepo;
import com.tel.AddressService.dto.AddressDTO;
import com.tel.AddressService.entity.Address;
import com.tel.AddressService.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepo addressRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public AddressDTO getAddress(int id) {
		System.out.println("port");
//		Address address = addressRepo.findAddressByEmployeeId(id);
		Address address = addressRepo.findByEmployeeId(id);
		AddressDTO addressDTO = modelMapper.map(address, AddressDTO.class);
		return addressDTO;
		
	}

	@Override
	public void saveAddress(AddressDTO addressDTO) {
		Address address = modelMapper.map(addressDTO, Address.class);
		addressRepo.save(address);
	}

}
