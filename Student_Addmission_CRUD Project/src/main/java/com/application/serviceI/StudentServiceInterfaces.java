package com.application.serviceI;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.application.model.Student;

public interface StudentServiceInterfaces {

    Student saveData(String studentData, MultipartFile addmissionFile, MultipartFile resultFile);
        
    List<Student> getAllStudentData();
    
	Student getSingleRecord(int rollNo);

	void postUpdateSingleRecordForId(String studentData, MultipartFile addmissionFile, MultipartFile resultFile);

	


}
