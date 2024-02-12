package com.app.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.SigninRequest;
import com.app.entities.User;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

	
	@Autowired
	private UserDao userDao;

	@Override
	public User authenticateEmployee(@Valid SigninRequest request) {
		return userDao.findByEmailAndPassword(request.getEmail(), request.getPassword()).orElseThrow();
	}

	
}
