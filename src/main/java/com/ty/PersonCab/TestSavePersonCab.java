package com.ty.PersonCab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSavePersonCab {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Cab cab=new Cab();
		cab.setDriverName("Neeraj");
		cab.setCost(3000);
		
		Person person1=new Person();
		person1.setName("Nitish");
		person1.setAge(24);
		person1.setEmail("niti@gmail.com");
		
		Person person2=new Person();
		person2.setName("Sandeep");
		person2.setAge(24);
		person2.setEmail("sandeep@gmail.com");
		
		List<Person> persons=new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		
		cab.setPerson(persons);
		
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityTransaction.commit();
		
	}

}
