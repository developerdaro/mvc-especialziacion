package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.PresentacionPersonal;
import com.analizape.repository.PresentacionPersonalRepository;

@Service
public class PresentacionPersonalServiceImpl implements PresentacionPersonalService{

	@Autowired
	private PresentacionPersonalRepository presentacionPersonalRepository;
	
	@Override
	public Iterable<PresentacionPersonal> findAll() {
		// TODO Auto-generated method stub
		return presentacionPersonalRepository.findAll();
	}

	@Override
	public Optional<PresentacionPersonal> findById(Integer id) {
		// TODO Auto-generated method stub
		return presentacionPersonalRepository.findById(id);
	}

	@Override
	public PresentacionPersonal save(PresentacionPersonal presentacionPersonal) {
		// TODO Auto-generated method stub
		return presentacionPersonalRepository.save(presentacionPersonal);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		presentacionPersonalRepository.deleteById(id);
	}

}
