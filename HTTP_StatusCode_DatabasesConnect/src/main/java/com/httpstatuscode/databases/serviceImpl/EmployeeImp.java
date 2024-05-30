package com.httpstatuscode.databases.serviceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.httpstatuscode.databases.model.Employee;
import com.httpstatuscode.databases.repository.EmployeeRepository;
import com.httpstatuscode.databases.serviceIn.EmployeeInterfaces;

@Service
public class EmployeeImp implements EmployeeInterfaces {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void saveDataEmployee(Employee e) {
        System.out.println("Saving Employee: " + e.getEmp_name());
        employeeRepository.save(e);
    }

	@Override
	public List<Employee> getAllEmployeeData() {
		List<Employee> all =  (List<Employee>) employeeRepository.findAll();
		Iterator<Employee> iterator = all.iterator();
		while(iterator.hasNext())
		{
			Employee next = iterator.next();
			System.out.println(next.getEmp_name());
			System.out.println(next.getEmpId());
			System.out.println(next.getEmpAddress());
			System.out.println(next.getEmpMobileNo());
			System.out.println(next.getEmpEmail());
		}
		return all;
	}

	@Override
	public Employee getSingleRecord(int empId) {
		Optional<Employee> byId = employeeRepository.findById(empId);
		if(byId.isPresent())
		{
			Employee employee = byId.get();
			System.out.println(employee.getEmpId());
			System.out.println(employee.getEmp_name());
			return employee;
		}else {
			
			return byId.get();
			
		}
	}

	public Employee updateSingleRecordID(int empId, Employee ed) {
		Optional<Employee> updatebyId = employeeRepository.findById(empId);
		if(!updatebyId.isPresent())
		{
			return null;
		}else {
			ed.setEmpId(empId);
			employeeRepository.save(ed);
			 return ed;
		}
	}

	@Override
	public boolean deleteSingleRecord(int empId) {
		Optional<Employee> byId = employeeRepository.findById(empId);
		if(!byId.isPresent())
		{
			return false;
		}else {
			employeeRepository.deleteById(empId);
			return true;
		}
	}
}
