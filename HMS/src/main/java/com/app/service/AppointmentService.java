package com.app.service;

import java.util.List;

import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.entities.Doctor;


public interface AppointmentService {

	String addAppoinment(Long patientId, Long doctorId, AppointmentDto apt);

	List<Appointment> getAllappointServ();

	
}
