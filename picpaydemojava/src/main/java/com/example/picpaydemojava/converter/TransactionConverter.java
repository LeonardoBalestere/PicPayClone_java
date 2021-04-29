package com.example.picpaydemojava.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.picpaydemojava.dto.TransactionDTO;
import com.example.picpaydemojava.model.Transaction;
import com.example.picpaydemojava.service.IUserService;

@Component
public class TransactionConverter extends ConveterBase<Transaction, TransactionDTO>{

	@Autowired
	private IUserService userService;
	
	@Override
	public TransactionDTO convertEntityToDTO(Transaction entity) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Transaction,TransactionDTO>(){
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity,TransactionDTO.class);
	}
	
	@SuppressWarnings("unchecked")
	public Page<TransactionDTO> convertpageEntitytoDTO(Page<Transaction> entity){
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Page<Transaction>, Page<TransactionDTO>>(){
			@Override
			protected void configure() {
			}
		});
		return modelMapper.map(entity,Page.class);
	}
	
	@Override
	public Transaction convertDTOToEntity(TransactionDTO dto) {
		return Transaction.builder()
				.code(dto.getCode())
				.datatime(dto.getDateTime())
				.value(dto.getValue())
				.destiny(userService.consultEntity(dto.getDestiny().getLogin()))
				.origin(userService.consultEntity(dto.getOrigin().getLogin()))
				.build();
	}
}
