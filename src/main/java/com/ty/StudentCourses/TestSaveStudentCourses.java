package com.ty.StudentCourses;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudentCourses {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Student student1=new Student();
		student1.setName("Neeraj");
		student1.setAge(24);
		
		Course courses1=new Course();
		courses1.setName("Java");
		courses1.setDuration(10);
		
		Course courses2=new Course();
		courses2.setName("HTML");
		courses2.setDuration(5);
		
		Course courses3=new Course();
		courses3.setName("CSS");
		courses3.setDuration(1);
		
		List<Course> courses=new ArrayList<Course>();
		courses.add(courses1);
		courses.add(courses2);
		courses.add(courses3);
		
		student1.setCourses(courses);
		
		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(courses1);
		entityManager.persist(courses2);
		entityManager.persist(courses3);
		entityTransaction.commit();
	}

}
