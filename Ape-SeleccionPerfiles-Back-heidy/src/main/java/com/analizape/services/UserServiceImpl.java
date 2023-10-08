package com.analizape.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analizape.models.user;
import com.analizape.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRespository;

	@Override
	public Iterable<user> findAll() {
		// TODO Auto-generated method stub
		return userRespository.findAll();
	}

	@Override
	public Optional<user> findById(Integer id) {
		// TODO Auto-generated method stub
		return userRespository.findById(id);
	}

	@Override
	public user save(user user) {
		// TODO Auto-generated method stub
		return userRespository.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		userRespository.deleteById(id);
		
	}

 
	
 

	 

}
