package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DoctorDao;
import com.app.dao.PatientDao;
import com.app.dto.DoctorDto;
import com.app.entities.Doctor;
import com.app.entities.DoctorSchedule;
import com.app.entities.Patient;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao docDao;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public Doctor addDoctorServ(Doctor doctor) {
		List<DoctorSchedule> listd = doctor.getDSchedule();
		doctor.addDSchedule(listd);
		return docDao.save(doctor);
	}


	@Override
	public List<Doctor> getAllDocsServ() {
		
		//return docDao.findAll();
		return docDao.getAllDoctor();
	}


	@Override
	public void updateStatus(Long docId) {
		
		Doctor doc=docDao.findById(docId).orElseThrow();
		doc.setStatus(false);
		docDao.save(doc);
		
	}


	@Override
	public void updateDoctor(DoctorDto detachedDoctor, Long docId) {
		//List<DoctorSchedule> list = detachedDoctor.getDSchedule();
		//detachedDoctor.addDSchedule(list);
		Doctor doctor=docDao.findById(docId).orElseThrow();
		mapper.map(detachedDoctor, doctor);
		
		
		
		
//		Patient patient = patientDao.findById(patientId).orElseThrow();
//		System.out.println(patient);
//		mapper.map(detachedPatient, patient);
//		System.out.println(patient);
//		
		
	}
	
//	public List<Doctor> getAllDoctors()
//	{
//		return docDao.getAllDoctor();
//	}

	

	
}
