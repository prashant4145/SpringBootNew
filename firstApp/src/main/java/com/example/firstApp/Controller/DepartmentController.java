package com.example.firstApp.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstApp.entity.Department;
import com.example.firstApp.exception.DepartmentNotFound;
import com.example.firstApp.service.DepartmentService;
import com.example.firstApp.service.DepartmentServiceImpl;

@RestController
public class DepartmentController {
//To add the logger into the class
	private final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	
	@Autowired
	@Qualifier("departmentServiceImpl")
	private DepartmentService departmentService;
	@PostMapping("departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside Post Method");//here we have added Log msg for console
		return departmentService.saveDepartment(department);
	}
	
	//to get list of all departments
	@GetMapping("/departments")
	public List<Department> getDepartmentList(){
		return departmentService.getDepartmentList();
	}
	
	//to get department by Id
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable ("id") Long departmentId) throws DepartmentNotFound {
		return departmentService.getDepartmentById(departmentId);
	}
	
	//Delete Department By ID
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable ("id") Long departmentId) {
		return departmentService.deleteDepartmentById(departmentId);
	}
	
	//Update Department By ID
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable ("id") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);
	}
	
	//get Department By Name
	@GetMapping("/departments/name/{departmentName}")
	public Department getDepartmentByName(@PathVariable ("departmentName") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}
	
	//get with multiple parameters
	@GetMapping("/departments/name/{departmentName}/code/{departmentCode}")
	public List<Department> findByDepartmentNameAndDepartmentCode(@PathVariable ("departmentName") String departmentName, @PathVariable ("departmentCode") String departmentCode){
		return departmentService.findByDepartmentNameAndDepartmentCode(departmentName, departmentCode);
	}
}
