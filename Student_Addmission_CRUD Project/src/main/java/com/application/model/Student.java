package com.application.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("rollno")
    private int rollNo;
    private String name;
    private String address;

    // final college - > CJC
    private final String college = "Complete Java Classes";

    // One To One
    @OneToOne
    private Addmission addmission;

    @OneToOne
    private Result result;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Addmission getAddmission() {
		return addmission;
	}

	public void setAddmission(Addmission addmission) {
		this.addmission = addmission;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getCollege() {
		return college;
	}
    
}
