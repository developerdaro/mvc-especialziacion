package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Experiencia;
import com.analizape.repository.ExperienciaRepository;

@Service 
public class ExperienciaServiceImpl implements ExperienciaService {

	@Autowired
	ExperienciaRepository experienciaRepository;
	
	@Override
	public Iterable<Experiencia> findAll() {
		// TODO Auto-generated method stub
		return experienciaRepository.findAll();
	}

	@Override
	public Optional<Experiencia> findById(Integer id) {
		// TODO Auto-generated method stub
		return experienciaRepository.findById(id);
	}

	@Override
	public Experiencia save(Experiencia experiencia) {
		// TODO Auto-generated method stub
		return experienciaRepository.save(experiencia);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		experienciaRepository.deleteById(id);
	}

}
