package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.NivelEstudios;
import com.analizape.repository.NivelEstudiosRepository;

@Service  
public class NivelEstudiosServiceImpl implements NivelEstudiosService{
	
	@Autowired
	NivelEstudiosRepository nivelEstudiosRepository;

	@Override
	public Iterable<NivelEstudios> findAll() {
		// TODO Auto-generated method stub
		return nivelEstudiosRepository.findAll();
	}

	@Override
	public Optional<NivelEstudios> findById(Integer id) {
		// TODO Auto-generated method stub
		return nivelEstudiosRepository.findById(id);
	}

	@Override
	public NivelEstudios save(NivelEstudios nivelEstudios) {
		// TODO Auto-generated method stub
		return nivelEstudiosRepository.save(nivelEstudios); 
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		nivelEstudiosRepository.deleteById(id);
	}
	
	

}
