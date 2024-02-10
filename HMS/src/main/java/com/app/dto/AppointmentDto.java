package com.app.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AppointmentDto {

	@JsonProperty
	@NotNull
	private String name;

	@JsonProperty
	@NotNull
	private int age;

	@JsonProperty
	@NotNull
	private String contactNo;

	@JsonProperty
	@NotNull
	private String relation;
	
	@JsonProperty(defaultValue = "false",access = Access.READ_ONLY)
	private boolean paymentStatus;

//	@JsonProperty(value = "doctor_Id")
//	private Long doctorId;
//	
//	@JsonProperty(value="patient_id")
//	private Long patientId;
}
