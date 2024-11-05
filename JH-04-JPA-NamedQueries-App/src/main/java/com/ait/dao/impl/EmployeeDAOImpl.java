package com.ait.dao.impl;

import java.util.List;

import com.ait.constants.AppConstants;
import com.ait.dao.EmployeeDAO;
import com.ait.entity.EmployeeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction(); 
		tx.begin();
		try {
			EmployeeEntity existingEmp = em.find(EmployeeEntity.class, emp.getEmpNo());
			if(existingEmp != null) {
				System.out.println("Employee Already present in DB ..");
			}
			else {
				em.persist(emp);
				tx.commit();
				System.out.println("Employee successfully added in DB");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("can not add the Employee ");
		}
		finally {
			em.close();
		}
		return null;
	}
	
	@Override
	public EmployeeEntity getEmployeeById(Integer empId) {
		EntityManager em = factory.createEntityManager(); 
		TypedQuery<EmployeeEntity> tq = em.createQuery(AppConstants.QUERY1,EmployeeEntity.class);
		tq.setParameter(1, empId);
		EmployeeEntity emp = tq.getSingleResult(); 
		em.close();
		return emp;
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		EntityManager em = factory.createEntityManager(); 
		TypedQuery<EmployeeEntity> tq = em.createQuery(AppConstants.QUERY2,EmployeeEntity.class);
		List<EmployeeEntity> list = tq.getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Object[]> getNameAndSal() {
		EntityManager em = factory.createEntityManager(); 
		TypedQuery<Object[]> tq = em.createQuery(AppConstants.QUERY3,Object[].class);
		List<Object[]> list = tq.getResultList();
		em.close();
		return list;
	}
	
	@Override
	public List<EmployeeEntity> executeNamedQuery(int deptNo) {
		EntityManager em = factory.createEntityManager(); 
		TypedQuery<EmployeeEntity> tq = em.createNamedQuery("Query4", EmployeeEntity.class) ;
		tq.setParameter(1, deptNo);
		List<EmployeeEntity> ls = tq.getResultList(); 
		return ls;
	}
	
	@Override
	public List executeNamedNativeQuery(int sal) {
		EntityManager em = factory.createEntityManager(); 
		Query q = em.createNamedQuery("Query5");
		q.setParameter(1, sal);
		List ls = q.getResultList();
		return ls;
	}
	
	@Override
	public void updateSalary(Integer empId,Double sal) {
		EntityManager em = factory.createEntityManager(); 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			EmployeeEntity existingEmp = em.find(EmployeeEntity.class, empId);
			if(existingEmp != null) {
				existingEmp.setSalary(sal);
				em.merge(existingEmp);
				tx.commit();
				System.out.println("Salary updated ");
			}
			else {
				System.out.println("Employee does not exist.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("some error occurs  ");
		}
		finally {
			em.close();
		}
	}
	

}
