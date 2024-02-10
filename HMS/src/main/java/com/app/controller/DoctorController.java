package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DoctorDto;
import com.app.dto.PatientDto;
import com.app.entities.Doctor;
import com.app.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
	
	@Autowired
	private DoctorService docService;
	
	@PostMapping
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return docService.addDoctorServ(doctor);
	}
	
	@GetMapping
	public List<Doctor> getAllDoctor(){
		
		return docService.getAllDocsServ();
	}
	
	@PutMapping("/{docId}")
	public void UpdateStatus(@PathVariable Long docId) {
		
		 docService.updateStatus(docId);
	}
	
	@PutMapping("doctId/{docId}")
	public void UpdatePatient(@PathVariable Long docId,@RequestBody DoctorDto detachedDoctor)
	{
		docService.updateDoctor(detachedDoctor,docId);
	}
	
	
}
