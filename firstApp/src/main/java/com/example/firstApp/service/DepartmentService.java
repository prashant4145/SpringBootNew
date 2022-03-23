package com.example.firstApp.service;

import java.util.List;

import com.example.firstApp.entity.Department;
import com.example.firstApp.exception.DepartmentNotFound;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getDepartmentList();

	public Department getDepartmentById(Long departmentId) throws DepartmentNotFound;

	public String deleteDepartmentById(Long departmentId);

	public Department updateDepartmentById(Long departmentId, Department department);

	public Department getDepartmentByName(String departmentName);

	public List<Department> findByDepartmentNameAndDepartmentCode(String departmentName, String departmentCode);

}
