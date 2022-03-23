package com.example.firstApp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.firstApp.entity.Department;
import com.example.firstApp.repository.DepartmentRepository;

class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;
	
	
	@BeforeEach
	void setUp() {
		Department department= new Department(1L, "IT", "Kopargaon", "IT-01");
		Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
	}

	@Test
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName="IT";
		Department found= (Department) departmentService.getDepartmentByName("IT");
		assertEquals(departmentName, found.getDepartmentName());
	}

}
