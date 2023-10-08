package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Entrevistas;
import com.analizape.repository.EntrevistasRepository;

@Service 
public class EntrevistasServiceImpl implements EntrevistasService {

	@Autowired
	EntrevistasRepository entrevistasRepository;
	
	@Override
	public Iterable<Entrevistas> findAll() {
		// TODO Auto-generated method stub
		return entrevistasRepository.findAll();
	}

	@Override
	public Optional<Entrevistas> findById(Integer id) {
		// TODO Auto-generated method stub
		return entrevistasRepository.findById(id);
	}

	@Override
	public Entrevistas save(Entrevistas entrevistas) {
		// TODO Auto-generated method stub
		return entrevistasRepository.save(entrevistas); 
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		entrevistasRepository.deleteById(id); 
	}

	
}
