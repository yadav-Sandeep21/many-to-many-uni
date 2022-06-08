package com.ty.StudentCourses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourses2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("Sandeep");
		student1.setAge(25);
		
		Course courses1=entityManager.find(Course.class, 5);
		Course courses2=entityManager.find(Course.class, 2);
		
		List<Course> courses=new ArrayList<Course>();
		courses.add(courses1);
		courses.add(courses2);
		
		student1.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityTransaction.commit();
	}

}
