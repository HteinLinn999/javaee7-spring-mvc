package com.turing.javaee7.mvc.demo.common;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Mapper {

	private ModelMapper modelMapper = new ModelMapper();

	public Mapper() {
		log.info("Mapper initialized");
	}
	
	public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream()
		        .map(element -> modelMapper.map(element, targetClass))
                .collect(java.util.stream.Collectors.toList());	
	}
	
	public<D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }
	
	public ModelMapper getModelMapper() {
		return modelMapper;
	}
	
}
