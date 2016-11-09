package com.ibrahim.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.ibrahim.model.Address;
import com.ibrahim.model.Student;
import com.ibrahim.session.JpaEntityManagerFactory;
import com.ibrahim.util.TimeStampFactory;

public class Create_Insert_Table {

	private static EntityManager entityManager = JpaEntityManagerFactory.buildEntityManager();
	private static EntityTransaction transaction = JpaEntityManagerFactory.transaction();

	public static void main(String[] args) {

		StudentDetail();
		AddressDetail();
	}

	private static void StudentDetail() {

		Student student = new Student();
		student.setName("ibrahim");
		student.setSurname("Sungur");
		student.setNo(0534);
		student.setAddDate(TimeStampFactory.getCurrentTimeStamp());

		transaction.begin();
		entityManager.persist(student);
		transaction.commit();
	}

	public static void AddressDetail() {

		Address address = new Address();
		address.setCity("Urfa");
		address.setDistrict("Halfeti");
		address.setAddDate(TimeStampFactory.getCurrentTimeStamp());
		
		transaction.begin();
		entityManager.persist(address);
		transaction.commit();
	}
}
