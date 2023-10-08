package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Liderazgo;
import com.analizape.repository.LiderazgoRepository;

@Service 
public class LiderazgoServiceImpl implements LiderazgoService{

	@Autowired
	LiderazgoRepository liderazgoRepository;
	
	@Override
	public Iterable<Liderazgo> findAll() {
		// TODO Auto-generated method stub
		return liderazgoRepository.findAll();
	}

	@Override
	public Optional<Liderazgo> findById(Integer id) {
		// TODO Auto-generated method stub
		return liderazgoRepository.findById(id);
	}

	@Override
	public Liderazgo save(Liderazgo liderazgo) {
		// TODO Auto-generated method stub
		return liderazgoRepository.save(liderazgo);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		liderazgoRepository.deleteById(id);
	}

}
