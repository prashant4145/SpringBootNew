package com.example.firstApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.firstApp.entity.Department;
import com.example.firstApp.exception.DepartmentNotFound;
@Service
public class XYZ implements DepartmentService {

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> getDepartmentList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDepartmentById(Long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findByDepartmentNameAndDepartmentCode(String departmentName, String departmentCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
