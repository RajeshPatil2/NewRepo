package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.application.model.Student;
import com.application.serviceI.StudentServiceInterfaces;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterfaces serviceInterfaces;

	@PostMapping("/postStudentData")
	public ResponseEntity<String> postSaveData(@RequestPart("student") String studentData,
			@RequestPart("addmissionFile") MultipartFile addmissionFile,
			@RequestPart("resultFile") MultipartFile resultFile) {

		Student studentDetails = serviceInterfaces.saveData(studentData, addmissionFile, resultFile);
		return new ResponseEntity<>("Student data added", HttpStatus.OK);
	}

	@GetMapping("/getAllStudentData")
	public ResponseEntity<List<Student>> getAllStudentData() {
		List<Student> ls = serviceInterfaces.getAllStudentData();
		return new ResponseEntity<List<Student>>(ls, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getSingleRecord/{rollNo}")
	public ResponseEntity<Student> getSaveData(@PathVariable int rollNo) {
		Student studentData = serviceInterfaces.getSingleRecord(rollNo);

		return new ResponseEntity<Student>(studentData, HttpStatus.OK);
	}

	@PutMapping("/updateSingleRecordId/{rollNo}")
	public void updateSingleRecordForId(@RequestPart("student") String studentData,

			@RequestPart("addmissionFile") MultipartFile addmissionFile,
			@RequestPart("resultFile") MultipartFile resultFile, @PathVariable int rollNo) 
	{
		serviceInterfaces.postUpdateSingleRecordForId(studentData, addmissionFile, resultFile);
	
		//return new ResponseEntity<Student>(studentDataReturn, HttpStatus.ACCEPTED);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
