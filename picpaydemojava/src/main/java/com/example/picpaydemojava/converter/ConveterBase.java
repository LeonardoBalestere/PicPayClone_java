package com.example.picpaydemojava.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class ConveterBase<E,D>{

	public abstract D convertEntityToDTO(E entity);
	
	public abstract E convertDTOToEntity(D dto);
	
	public List<D> convertEntitiesToDTO(List<E> entities){
		List<D> dtos = new ArrayList<>();
		entities.stream().forEach(entity -> dtos.add(convertEntityToDTO(entity)));
		return dtos;
	}
	
	public List<E> convertDTOsToEntity(List<D> dtos){
		List<E> entity = new ArrayList<>();
		dtos.stream().forEach(dto -> entity.add(convertDTOToEntity(dto)));
		return entity;
	}
}