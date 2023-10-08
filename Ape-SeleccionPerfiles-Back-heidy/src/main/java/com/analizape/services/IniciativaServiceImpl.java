package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Iniciativa;
import com.analizape.repository.IniciativaRepository;
import com.analizape.repository.RolRepository;

@Service 
public class IniciativaServiceImpl implements IniciativaService{

	@Autowired
	private IniciativaRepository iniciativaRepository;
	
	@Override
	public Iterable<Iniciativa> findAll() {
		// TODO Auto-generated method stub
		return iniciativaRepository.findAll();
	}

	@Override
	public Optional<Iniciativa> findById(Integer id) {
		// TODO Auto-generated method stub
		return iniciativaRepository.findById(id);
	}

	@Override
	public Iniciativa save(Iniciativa iniciativa) {
		// TODO Auto-generated method stub
		return iniciativaRepository.save(iniciativa);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		iniciativaRepository.deleteById(id);
	}

}
