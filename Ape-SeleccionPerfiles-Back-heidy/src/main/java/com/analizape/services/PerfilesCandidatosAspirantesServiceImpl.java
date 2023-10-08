package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.PerfilesCandidatosAspirantes;
import com.analizape.repository.PerfilesCandidatosAspirantesRepository;

@Service
public class PerfilesCandidatosAspirantesServiceImpl implements PerfilesCandidatosAspirantesService{

	@Autowired
	private PerfilesCandidatosAspirantesRepository perfilesCandidatosAspirantesRepository;
	
	@Override
	public Iterable<PerfilesCandidatosAspirantes> findAll() {
		// TODO Auto-generated method stub
		return perfilesCandidatosAspirantesRepository.findAll();
	}

	@Override
	public Optional<PerfilesCandidatosAspirantes> findById(Integer id) {
		// TODO Auto-generated method stub
		return perfilesCandidatosAspirantesRepository.findById(id);
	}

	@Override
	public PerfilesCandidatosAspirantes save(PerfilesCandidatosAspirantes perfilesCandidatosAspirantes) {
		// TODO Auto-generated method stub
		return perfilesCandidatosAspirantesRepository.save(perfilesCandidatosAspirantes);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		perfilesCandidatosAspirantesRepository.deleteById(id);
	}

}
