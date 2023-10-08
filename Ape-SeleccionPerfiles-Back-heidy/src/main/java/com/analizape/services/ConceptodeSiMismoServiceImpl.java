package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.ConceptodeSiMismo;
import com.analizape.repository.ConceptodeSiMismoRepository;

@Service
public class ConceptodeSiMismoServiceImpl implements ConceptodeSiMismoService {

	@Autowired
	private ConceptodeSiMismoRepository conceptodeSiMismoRepository;
	
	@Override
	public Iterable<ConceptodeSiMismo> findAll() {
		// TODO Auto-generated method stub
		return conceptodeSiMismoRepository.findAll();
	}

	@Override
	public Optional<ConceptodeSiMismo> findById(Integer id) {
		// TODO Auto-generated method stub
		return conceptodeSiMismoRepository.findById(id);
	}

	@Override
	public ConceptodeSiMismo save(ConceptodeSiMismo conceptodeSiMismo) {
		// TODO Auto-generated method stub
		return conceptodeSiMismoRepository.save(conceptodeSiMismo);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		conceptodeSiMismoRepository.deleteById(id);
	}

}
