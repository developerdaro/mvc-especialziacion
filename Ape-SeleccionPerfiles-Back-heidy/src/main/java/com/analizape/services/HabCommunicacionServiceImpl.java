package com.analizape.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analizape.models.HabComuicacion;
import com.analizape.models.Rol;
import com.analizape.repository.HabComunicacionRepository;
import com.analizape.repository.RolRepository;

@Service 
public class HabCommunicacionServiceImpl implements HabComunicacionService{

	@Autowired
	private HabComunicacionRepository habComunicacionRepository;

	@Override
	public Iterable<HabComuicacion> findAll() {
		// TODO Auto-generated method stub
		return habComunicacionRepository.findAll();
	}

	@Override
	public Optional<HabComuicacion> findById(Integer id) {
		// TODO Auto-generated method stub
		return habComunicacionRepository.findById(id);
	}


	@Override
	public HabComuicacion save(HabComuicacion habComuicacion) {
		// TODO Auto-generated method stub
		return habComunicacionRepository.save(habComuicacion);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		habComunicacionRepository.deleteById(id);
	}

}
