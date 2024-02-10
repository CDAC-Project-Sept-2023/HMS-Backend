package com.app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="appointment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude ="patient")
public class Appointment extends BaseEntity {

	@Column(name="name",length = 200)
	private String name;
	
	@Column()
	private int age;
	
	@Column(length = 20,name = "contact_no")
	private String contactNo;
	
	@Column(name="relation",length = 100)
	private String relation;
	
	@Column(name="payment_amt")
	private double paymentAmount;
	
	@Column(name="payment_status",nullable = false)
	private Boolean paymentStatus;
	
	@ManyToOne
	@JoinColumn(name="patient_id",nullable = false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id",nullable = false)
	private Doctor doctor;
	
	public void addAppointment(Patient patient, Doctor doctor) {

		this.setPatient(patient);
		this.setDoctor(doctor);
	}

	

	public void removeAppointment(Patient patient, Doctor doctor) {

		this.setDoctor(null);
		this.setPatient(null);
	}



	public Appointment(Doctor doctor2, Patient patient2, Appointment apt) {
		
		this.setDoctor(doctor2);
		this.setPatient(patient2);
		this.setAge(apt.getAge());
		this.setContactNo(apt.getContactNo());
		this.setName(apt.getName());
		this.setRelation(apt.getRelation());
		this.setPaymentStatus(true);
	}

}
