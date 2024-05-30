package com.application.serviceImp;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.model.Addmission;
import com.application.model.Result;
import com.application.model.Student;
import com.application.repository.AddmissionRepository;
import com.application.repository.ResultRepository;
import com.application.repository.StudentRepository;
import com.application.serviceI.StudentServiceInterfaces;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StudentServiceImpl implements StudentServiceInterfaces {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddmissionRepository addmissionRepository;

	@Autowired
	ResultRepository resultRepository;

	@Override
	public Student saveData(String studentData, MultipartFile addmissionFile, MultipartFile resultFile) {
		ObjectMapper objectMapper = new ObjectMapper();

		Student student = null;
		try {
			student = objectMapper.readValue(studentData, Student.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Addmission addmission = new Addmission();
		try {
			addmission.setId(addmissionFile.getSize());
			addmission.setTenMarksheet(addmissionFile.getBytes());
			addmission.setTwelveMarksheet(addmissionFile.getBytes());
			addmission.setAadharCard(addmissionFile.getBytes());
			addmission.setPanCard(addmissionFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		addmission = addmissionRepository.save(addmission);
		student.setAddmission(addmission);

		Result result = new Result();
		try {
			result.setSem1(resultFile.getBytes());
			result.setSem2(resultFile.getBytes());
			result.setSem3(resultFile.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		result = resultRepository.save(result);
		student.setResult(result);
		student.setAddress(studentData);

		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudentData() {
		List<Student> s = (List<Student>) studentRepository.findAll();
		return s;
	}

	@Override
	public Student getSingleRecord(int rollNo) {
		Optional<Student> byId = studentRepository.findById(rollNo);

		Student student = byId.get();

		return student;
	}

	@Override
	public void postUpdateSingleRecordForId(String studentData, MultipartFile addmissionFile,
			MultipartFile resultFile) {

		ObjectMapper objectMapper = new ObjectMapper();

		Student student = null;

		try {

			student = objectMapper.readValue(studentData, Student.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Addmission addmission = new Addmission();

		try {

			addmission.setTenMarksheet(addmissionFile.getBytes());
			addmission.setTwelveMarksheet(addmissionFile.getBytes());
			addmission.setAadharCard(addmissionFile.getBytes());
			addmission.setPanCard(addmissionFile.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		addmission = addmissionRepository.save(addmission);
		student.setAddmission(addmission);
		student.setAddress(student.getAddress());

		Result result = new Result();
		try {

			result.setSem1(resultFile.getBytes());
			result.setSem2(resultFile.getBytes());
			result.setSem3(resultFile.getBytes());

		} catch (IOException e) {

			e.printStackTrace();
		}

	//	resultRepository.save(result);

		result = resultRepository.save(result);
		student.setResult(result);
		student.setAddress(student.getAddress());

		studentRepository.save(student);

		// return StudentServiceInterfaces.save(student);

	}

}
