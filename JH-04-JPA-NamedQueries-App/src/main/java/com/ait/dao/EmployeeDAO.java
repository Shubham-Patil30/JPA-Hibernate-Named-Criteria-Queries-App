package com.ait.dao;

import java.util.List;

import com.ait.entity.EmployeeEntity;

public interface EmployeeDAO {
	public EmployeeEntity saveEmployee(EmployeeEntity emp);
	
	public EmployeeEntity getEmployeeById(Integer empId);
	
	public List<EmployeeEntity> getAllEmployee(); 
	
	public List<Object[]>  getNameAndSal();
	
	public List<EmployeeEntity> executeNamedQuery(int deptNo); 
	
	public List executeNamedNativeQuery(int sal); 
	
	public void updateSalary(Integer empId,Double sal) ; 
	
	
	
}
