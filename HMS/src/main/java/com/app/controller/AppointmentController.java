package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.service.AppointmentService;

@RestController
@RequestMapping("/appoinment")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
public class AppointmentController {

	@Autowired
	private AppointmentService aptService;

	@PostMapping()
	public String doAppoinment(@RequestParam Long patientId, @RequestParam Long doctorId,
			@RequestBody @Valid AppointmentDto aptDto) {
		System.out.println(aptDto);
		return aptService.addAppoinment(patientId, doctorId, aptDto);

	}

	@GetMapping
	public List<Appointment> getAllAppointment() {
		return aptService.getAllappointServ();

		
		
	}
}
