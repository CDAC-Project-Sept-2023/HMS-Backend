package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AppointmentDao;
import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.AppointmentDto;
import com.app.entities.Appointment;
import com.app.entities.Doctor;
import com.app.entities.Patient;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentDao aptDao;
	
	@Autowired
	private DoctorDao docDao;

	@Autowired
	private ModelMapper mappper;
	@Autowired
	private PatientDao patientDao;

	@Override
	public String addAppoinment(Long patientId, Long doctorId, AppointmentDto apt) {

			Patient patient=patientDao.findById(patientId).orElseThrow();
			Doctor doctor = docDao.findById(doctorId).orElseThrow();
			System.out.println("apt dto "+ apt);
			
		Appointment newApt = new Appointment(doctor,patient,mappper.map(apt, Appointment.class));
		System.out.println("full apt"+newApt);
		aptDao.save(newApt);
		return "successfulyy";
	}

	@Override
	public List<Appointment> getAllappointServ() {
		
		return aptDao.findAll();
	}

	


	
}
