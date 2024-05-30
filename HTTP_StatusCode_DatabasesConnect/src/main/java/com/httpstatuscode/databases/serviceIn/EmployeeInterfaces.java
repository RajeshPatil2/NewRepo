package com.httpstatuscode.databases.serviceIn;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.httpstatuscode.databases.model.Employee;

public interface EmployeeInterfaces {
	void saveDataEmployee(Employee e);

	List<Employee> getAllEmployeeData();

	Employee getSingleRecord(int empId);

	Employee updateSingleRecordID(int empId, Employee ed);

	boolean deleteSingleRecord(int empId);
}
