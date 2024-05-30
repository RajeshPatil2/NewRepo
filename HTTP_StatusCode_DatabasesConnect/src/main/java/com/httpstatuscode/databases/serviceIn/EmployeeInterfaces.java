package com.httpstatuscode.databases.serviceIn;

import java.util.List;

import com.httpstatuscode.databases.model.Employee;

public interface EmployeeInterfaces {
	void saveDataEmployee(Employee e);

	List<Employee> getAllEmployeeData();

	Employee getSingleRecord(int empId);

	Employee updateSingleRecordID(int empId, Employee ed);

	boolean deleteSingleRecord(int empId);
}
