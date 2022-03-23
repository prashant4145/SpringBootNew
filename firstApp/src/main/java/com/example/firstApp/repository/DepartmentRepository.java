package com.example.firstApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.firstApp.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	//We can Always create this method by keeping naming convention
	//use findBy and name of vaiable appended in camelcase
	//Also we can use findByNameIgnoreCase
	//As there was multiple departments with the same name I have used List Here 
	
	//public List<Department> findByDepartmentName(String departmentName);
	
	public Department findByDepartmentName(String departmentName);
	
	//---This is imp please go through
	public List<Department> findByDepartmentNameAndDepartmentCode(String departmentName, String departmentCode);

}
