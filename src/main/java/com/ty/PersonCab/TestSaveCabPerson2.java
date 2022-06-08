package com.ty.PersonCab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCabPerson2 {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Cab cab=new Cab();
		cab.setDriverName("Nishitha");
		cab.setCost(3000);
		
		Person person1=entityManager.find(Person.class, 3);
		Person person2=entityManager.find(Person.class, 2);
		
		
		List<Person> persons=new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		
		cab.setPerson(persons);
		
		entityTransaction.begin();
		entityManager.persist(cab);
		entityTransaction.commit();
	}

}
