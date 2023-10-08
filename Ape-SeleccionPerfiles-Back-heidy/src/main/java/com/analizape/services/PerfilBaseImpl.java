package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.PerfilBase;
import com.analizape.repository.PerfilBaseRepository;

@Service
public class PerfilBaseImpl implements PerfilBaseService {
	
	@Autowired
	private PerfilBaseRepository perfilBaseRepository;

	@Override
	public Iterable<PerfilBase> findAll() {
		// TODO Auto-generated method stub
		return perfilBaseRepository.findAll();
	}

	@Override
	public Optional<PerfilBase> findById(Integer id) {
		// TODO Auto-generated method stub
		return perfilBaseRepository.findById(id);
	}

	@Override
	public PerfilBase save(PerfilBase perfilBase) {
		// TODO Auto-generated method stub
		return perfilBaseRepository.save(perfilBase); 
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		perfilBaseRepository.deleteById(id);
		
	}

	
}
