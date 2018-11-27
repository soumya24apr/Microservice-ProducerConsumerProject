package com.service.consumer.controller;


public class PatientAppointmentDetail {

	private Integer id;

	private String patientName;
	
	private String doctorName;
	
	private String hospital;
	
	private String checkUpType;
	
	public Integer getId() {
		return id;
	}
	
	public PatientAppointmentDetail(){
		
	}

	public PatientAppointmentDetail(String patientName,
			String doctorName, String hospital, String checkUpType) {
	
		this.patientName = patientName;
		this.doctorName = doctorName;
		this.hospital = hospital;
		this.checkUpType = checkUpType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getCheckUpType() {
		return checkUpType;
	}

	public void setCheckUpType(String checkUpType) {
		this.checkUpType = checkUpType;
	}
	
}
