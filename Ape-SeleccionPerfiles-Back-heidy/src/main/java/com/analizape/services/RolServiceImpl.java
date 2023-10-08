package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.Rol;
import com.analizape.repository.RolRepository;


@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Override
	public Iterable<Rol> findAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public Optional<Rol> findById(Integer id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id);
	}

	@Override
	public Rol save(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public void deleteById(Integer id) {
		rolRepository.deleteById(id);
		
	}
}
