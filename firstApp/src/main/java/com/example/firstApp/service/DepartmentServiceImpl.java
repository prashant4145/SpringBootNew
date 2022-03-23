package com.example.firstApp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstApp.entity.Department;
import com.example.firstApp.exception.DepartmentNotFound;
import com.example.firstApp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}
	@Override
	public Department getDepartmentById(Long departmentId) throws DepartmentNotFound {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if(department.isEmpty()) {
			throw new DepartmentNotFound("Department Not Available");
		}
		return department.get();
	}
	@Override
	public String deleteDepartmentById(Long departmentId) {
		try{departmentRepository.deleteById(departmentId);
		return departmentId +" deleted...!!";}
		catch(Exception e) {
			return "Department is not Available";
		}
	}
	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {
		Department dept =departmentRepository.getById(departmentId);
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())) {
		dept.setDepartmentAddress(department.getDepartmentAddress());}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())) {
		dept.setDepartmentCode(department.getDepartmentCode());}
		if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())) {
		dept.setDepartmentName(department.getDepartmentName());}
		return departmentRepository.save(dept);
		
	}
	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}
	@Override
	public List<Department> findByDepartmentNameAndDepartmentCode(String departmentName, String departmentCode) {
		return departmentRepository.findByDepartmentNameAndDepartmentCode(departmentName, departmentCode);
	}
	

}
