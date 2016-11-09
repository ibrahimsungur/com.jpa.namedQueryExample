package com.ibrahim.session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaEntityManagerFactory {
	public static EntityManagerFactory factory;
	public static EntityManager entityManager;

	public static EntityManager buildEntityManager() {
		try {
			// Persistence-Unit name="com.jpa.namedQuery"
			factory = Persistence.createEntityManagerFactory("com.jpa.namedQuery");
			entityManager = factory.createEntityManager();
		} catch (Exception e) {
			System.err.println("Entity Manager calistirilmadi.." + e);
		}
		return entityManager;
	}

	// transaction nesnesi
	public static EntityTransaction transaction() {
		return entityManager.getTransaction();
	}
}
