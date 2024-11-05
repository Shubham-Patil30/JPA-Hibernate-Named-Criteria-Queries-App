package com.ait.test;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import com.ait.dao.EmployeeDAO;
import com.ait.dao.impl.EmployeeDAOImpl;
import com.ait.entity.EmployeeEntity;

public class Test {

	public static void main(String[] args) {
		EmployeeEntity emp = new EmployeeEntity(); 
		EmployeeDAO dao = new EmployeeDAOImpl(); 
		
		emp.setEmpNo(103);
		emp.setEmpName("Sid");
		emp.setDeptNo(3);
		emp.setSalary(30000.00);
	
		EmployeeEntity emp1 = new EmployeeEntity(); 
		emp1.setEmpNo(104);
		emp1.setEmpName("Komal");
		emp1.setDeptNo(2);
		emp1.setSalary(65000.00);
		
//		dao.saveEmployee(emp);
//		dao.saveEmployee(emp1);
		
		dao.updateSalary(103, 30000.00);
		dao.updateSalary(104, 65000.00);
		
		
//		
//		EmployeeEntity e1 =  dao.getEmployeeById(101);
//		System.out.println(e1);
//		
//		List<EmployeeEntity> empList = dao.getAllEmployee(); 
//		
//		for (EmployeeEntity employee : empList) {
//			System.out.println(employee);
//		}
//		
//		List<Object[]>  l2 = dao.getNameAndSal(); 
//		for (Object[] objects : l2) {
//			System.out.println("NAME: "+objects[0]+ "SAL: "+objects[1]);
//		}
		
		List  ls = dao.executeNamedNativeQuery(30000);
		List<EmployeeEntity> l2 = dao.executeNamedQuery(2);
		
		ls.forEach(System.out::println);
		System.out.println("===================================");
		l2.forEach(System.out::println);

		
	}

}
