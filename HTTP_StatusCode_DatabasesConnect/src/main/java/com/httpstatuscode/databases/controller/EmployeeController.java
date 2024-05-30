package com.httpstatuscode.databases.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.httpstatuscode.databases.model.Employee;
import com.httpstatuscode.databases.serviceIn.EmployeeInterfaces;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeInterfaces employeeInterfaces;

	@PostMapping("/postEmployee")
	public ResponseEntity<String> postDataEmployee(@RequestBody Employee e) {
		System.out.println("Received Employee: " + e.getEmp_name());
		employeeInterfaces.saveDataEmployee(e);
		return new ResponseEntity<>("Post Employee Data Successfully..!!", HttpStatus.ACCEPTED);
	}

	@GetMapping("/getEmployee")
	public ResponseEntity<List<Employee>> getDataEmployee() {
		List<Employee> allEmployeeData = (List<Employee>) employeeInterfaces.getAllEmployeeData();

		return new ResponseEntity<>(allEmployeeData, HttpStatus.OK);
	}

	@GetMapping("/getsingleEmployeeData/{empId}")
	public ResponseEntity<Employee> getSingleRecordById(@PathVariable int empId)
	{
		Employee eid = employeeInterfaces.getSingleRecord(empId);
		if (eid == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(eid, HttpStatus.OK);
		}
	}

	@PutMapping("/putSingleUpdateData/{empId}")
	public ResponseEntity<Employee> updateSingleRecordByID(@PathVariable int empId, @RequestBody Employee ed)
	{
		Employee emid =employeeInterfaces.updateSingleRecordID(empId, ed);
		if(emid == null)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(emid, HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/deleteSingleRecord/{empId}")
	public ResponseEntity<String> deleteSingleRecord(@PathVariable int empId)
	{
		boolean isDeleted = employeeInterfaces.deleteSingleRecord(empId);
		if(!isDeleted)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>("Employee id deleted successfully", HttpStatus.OK);
			
		}
	}
}
