package com.ty.StudentCourses;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetStudentCourses {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Student student=entityManager.find(Student.class, 2);
		if(student!=null)
		{
			List<Course> courses=student.getCourses();
			
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getAge());
			for(Course course : courses) {
				System.out.println("Course id is: "+course.getId());
				System.out.println("Course Name is: "+course.getName());
				System.out.println("Course Duration is: "+course.getDuration());
			}
		}
		else
		{
			System.out.println("No Studnt available");
		}
	}

}
