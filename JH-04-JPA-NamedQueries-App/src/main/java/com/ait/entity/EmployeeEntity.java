package com.ait.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="EMP")
@NamedQuery(name = "Query4" ,query = "FROM  EmployeeEntity e WHERE e.deptNo = ?1")
@NamedNativeQuery(name = "Query5", query="SELECT * FROM EMP WHERE SAL > ?1",resultClass = EmployeeEntity.class)
public class EmployeeEntity{
	@Id
	@Column(name="EMPNO")
	private Integer empNo; 
	
	@Column(name="ENAME")
	private String empName; 
	
	@Column(name="DEPTNO")
	private Integer deptNo; 
	
	@Column(name="SAL")
	private Double salary ;

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empNo=" + empNo + ", empName=" + empName + ", deptNo=" + deptNo + ", Salary=" + salary
				+ "]";
	} 
	
}
