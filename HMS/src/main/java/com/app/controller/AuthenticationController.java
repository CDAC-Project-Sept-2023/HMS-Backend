package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SigninRequest;
import com.app.entities.User;
import com.app.service.AuthenticationService;


@RestController
@RequestMapping("/authenticate")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AuthenticationController {

	@Autowired
	private AuthenticationService authServ;


	@PostMapping("/signin")
	public User authenticateEmp(@RequestBody @Valid SigninRequest request) {
		System.out.println("in auth emp " + request);
		return authServ.authenticateEmployee(request);

	}

}
